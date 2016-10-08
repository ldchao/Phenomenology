package test.DaoImpl; 

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* UserDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ�� 8, 2016</pre> 
* @version 1.0 
*/ 
public class UserDaoImplTest { 
UserDao userDao;
@Before
public void before() throws Exception {
    userDao=new UserDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: persist(User user) 
* 
*/ 
@Test
public void testPersist() throws Exception { 
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
    userDao.delete(1);
} 

/** 
* 
* Method: update(User user) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findById(int id) 
* 
*/ 
@Test
public void testFindById() throws Exception { 
//TODO: Test goes here... 
} 


} 
