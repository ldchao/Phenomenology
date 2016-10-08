package test.DaoImpl; 

import Dao.PersonDao;
import DaoImpl.PersonDaoImpl;
import ENUM.Language;
import ENUM.Type;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

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
} 

/** 
* 
* Method: getByTypeAndLanguage(Type type, Language language) 
* 
*/ 
@Test
public void testGetByTypeAndLanguage() throws Exception { 
//TODO: Test goes here...
    Type type=Type.Article;
    Language language=Language.ch;
    System.out.println(personDao.getByTypeAndLanguage(type,language).size());
} 


} 
