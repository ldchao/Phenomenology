package Dao;

import POJO.Person;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface PersonDao {
    public int pesist(Person person);

    public void delete(int id);

    public void update(Person person);

    public List<Person> findAll();
}
