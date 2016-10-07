package DaoImpl;

import Dao.BaseDao;
import Dao.PersonDao;
import POJO.Person;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class PersonDaoImpl implements PersonDao{
    BaseDao baseDao;
    public static final String NAME="name";
    public int pesist(Person person) {
        baseDao=new BaseDaoImpl();
        Person po= (Person) baseDao.persist(person);
        return po.getId();
    }

    public void delete(int id) {
        baseDao=new BaseDaoImpl();
        Person person=new Person();
        person.setId(id);
        baseDao.delete(person);
    }

    public void update(Person person) {
        baseDao=new BaseDaoImpl();
        baseDao.update(person);
    }

    public List<Person> findAll() {
        baseDao=new BaseDaoImpl();
        return (List<Person>) baseDao.findAll("Person");
    }

    public Person getById(int id) {
        baseDao=new BaseDaoImpl();
        return (Person) baseDao.findById(id,Person.class);
    }

    public List<Person> getByPersonName(String name) {
        baseDao=new BaseDaoImpl();
        String[] properties={NAME};
        Object[] values={name};
        return (List<Person>) baseDao.findByProperties("Person",properties,values);
    }
}
