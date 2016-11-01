package test.DaoImpl; 

import Dao.SaAttachmentDao;
import DaoImpl.SaAttachmentDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

/** 
* SaAttachmentDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮһ�� 1, 2016</pre> 
* @version 1.0 
*/ 
public class SaAttachmentDaoImplTest { 
SaAttachmentDao saAttachmentDao;
@Before
public void before() throws Exception {
    saAttachmentDao=new SaAttachmentDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: pesist(SaAttachment saAttachment) 
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
    saAttachmentDao.delete(1);
} 

/** 
* 
* Method: update(SaAttachment saAttachment) 
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


} 
