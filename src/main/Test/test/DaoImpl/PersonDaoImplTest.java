package test.DaoImpl; 

import Dao.PersonDao;
import DaoImpl.PersonDaoImpl;
import ENUM.Language;
import ENUM.Type;
import POJO.Person;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/** 
* PersonDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ�� 8, 2016</pre> 
* @version 1.0 
*/ 
public class PersonDaoImplTest { 
PersonDao personDao;
@Before
public void before() throws Exception {
    personDao=new PersonDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: pesist(Person person) 
* 
*/ 
@Test
public void testPesist() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here...
    personDao.delete(10);
} 

/** 
* 
* Method: update(Person person) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here...
    List<Person> list=personDao.findAll();
    for (Person p :
            list) {
        System.out.println(p.getId());
    }
} 

/** 
* 
* Method: getById(int id) 
* 
*/ 
@Test
public void testGetById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getByPersonName(String name) 
* 
*/ 
@Test
public void testGetByPersonName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rank(ArrayList<Integer> sequence) 
* 
*/ 
@Test
public void testRank() throws Exception { 
//TODO: Test goes here...
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    arrayList.add(14);
    arrayList.add(1);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(6);
    arrayList.add(9);
    arrayList.add(8);
    arrayList.add(12);
    arrayList.add(13);
    arrayList.add(2);
    personDao.rank(arrayList);
} 

/** 
* 
* Method: getByTypeAndLanguage(Type type, Language language) 
* 
*/ 
@Test
public void testGetByTypeAndLanguage() throws Exception { 
//TODO: Test goes here...
    Type type=Type.OfficeBearer;
    Language language=Language.ch;
    List<Person> persons=personDao.getByTypeAndLanguage(type,language);
    for (Person person :
            persons) {
        System.out.println(person.getId());
    }
}


} 
