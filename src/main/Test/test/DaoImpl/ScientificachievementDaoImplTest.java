package test.DaoImpl; 

import Dao.ScientificachievementDao;
import DaoImpl.ScientificachievementDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ScientificachievementDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮһ�� 1, 2016</pre> 
* @version 1.0 
*/ 
public class ScientificachievementDaoImplTest { 
ScientificachievementDao scientificachievementDao;
@Before
public void before() throws Exception {
    scientificachievementDao=new ScientificachievementDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: pesist(Scientificachievement scientificachievement) 
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
    scientificachievementDao.delete(11);
} 

/** 
* 
* Method: update(Scientificachievement scientificachievement) 
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
* Method: find(Type type, Language language) 
* 
*/ 
@Test
public void testFind() throws Exception { 
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
* Method: getBySaTitle(String title) 
* 
*/ 
@Test
public void testGetBySaTitle() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSaAttachment(int id) 
* 
*/ 
@Test
public void testGetSaAttachment() throws Exception { 
//TODO: Test goes here... 
} 


} 
