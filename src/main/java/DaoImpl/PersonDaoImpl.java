package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.PersonDao;
import ENUM.Language;
import ENUM.Type;
import POJO.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class PersonDaoImpl implements PersonDao{
    BaseDao baseDao;
    public static final String NAME="name";
    public static final String TYPE="type";
    public static final String LANGUAGE="language";

    public PersonDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public int pesist(Person person) {
        try {
            Person po= (Person) baseDao.persist(person);
            return po.getId();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public void delete(int id) {
        Person person=new Person();
        person.setId(id);
        baseDao.delete(person);
    }

    public void update(Person person) {
        baseDao.update(person);
    }

    public List<Person> findAll() {
        try {
            return (List<Person>) baseDao.findAll("Person");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Person getById(int id) {
        try {
            return (Person) baseDao.findById(id,Person.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Person> getByPersonName(String name) {
        try {
            String finalString="%";
            for (int i=0;i<name.length();i++){
                finalString+=name.charAt(i);
                finalString+="%";
            }
            String hql="from Person p where p.name like '"+finalString+"'";
            return (List<Person>) baseDao.findByHql(hql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void rank(ArrayList<Integer> sequence) {
        ArrayList<Person> arrayList=(ArrayList<Person>)baseDao.findAll("Person");
        baseDao.clean("Person");
        for (int i=0;i<sequence.size();i++){
            for (int j=0;j<arrayList.size();j++){
                if (arrayList.get(j).getId()==sequence.get(i)){
                    arrayList.get(j).setSequence(i+1);
                    break;
                }
            }
        }
        Session session= DBconnection.getSession();
        try {
            for (Person person:arrayList){
                session.save(person);
            }
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Person> getByTypeAndLanguage(Type type, Language language) {
        try {
            String[] properties={TYPE,LANGUAGE};
            Object[] values={type,language};
            return (List<Person>) baseDao.findByProperties("Person",properties,values);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
