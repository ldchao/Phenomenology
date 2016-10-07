package Dao;

import ENUM.Language;
import ENUM.Type;
import POJO.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface PersonDao {
    public int pesist(Person person);

    public void delete(int id);

    public void update(Person person);

    public List<Person> findAll();

    public Person getById(int id);

    public List<Person> getByPersonName(String name);

    public void rank(ArrayList<Person> arrayList);

    public List<Person> getByTypeAndLanguage(Type type, Language language);
}
