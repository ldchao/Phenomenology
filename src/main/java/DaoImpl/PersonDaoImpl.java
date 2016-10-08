package DaoImpl;

import Dao.BaseDao;
import Dao.PersonDao;
import ENUM.Language;
import ENUM.Type;
import POJO.Person;

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
        Person po= (Person) baseDao.persist(person);
        return po.getId();
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
        return (List<Person>) baseDao.findAll("Person");
    }

    public Person getById(int id) {
        return (Person) baseDao.findById(id,Person.class);
    }

    public List<Person> getByPersonName(String name) {
        String finalString="%";
        for (int i=0;i<name.length();i++){
            finalString+=name.charAt(i);
            finalString+="%";
        }
        String hql="from Person p where p.name like '"+finalString+"'";
        return (List<Person>) baseDao.findByHql(hql);
    }

    public void rank(ArrayList<Integer> sequence) {
        baseDao.clean("Person");
    }

    public List<Person> getByTypeAndLanguage(Type type, Language language) {
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Person>) baseDao.findByProperties("Person",properties,values);
    }
}
