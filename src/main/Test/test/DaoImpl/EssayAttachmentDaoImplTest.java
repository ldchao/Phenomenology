package test.DaoImpl; 

import Dao.EssayAttachmentDao;
import DaoImpl.EssayAttachmentDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* EssayAttachmentDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ�� 11, 2016</pre> 
* @version 1.0 
*/ 
public class EssayAttachmentDaoImplTest { 
EssayAttachmentDao essayAttachmentDao;
@Before
public void before() throws Exception {
    essayAttachmentDao=new EssayAttachmentDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: pesist(EssayAttachment essayAttachment) 
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
    essayAttachmentDao.delete(15);
} 

/** 
* 
* Method: update(EssayAttachment essayAttachment) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
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
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 


} 
