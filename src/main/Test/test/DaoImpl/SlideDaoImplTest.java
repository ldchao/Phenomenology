package test.DaoImpl; 

import Dao.SlideDao;
import DaoImpl.SlideDaoImpl;
import POJO.Slide;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* SlideDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮһ�� 1, 2016</pre> 
* @version 1.0 
*/ 
public class SlideDaoImplTest { 
SlideDao slideDao;
@Before
public void before() throws Exception {
    slideDao=new SlideDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: pesist(Slide slide) 
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
    slideDao.delete(4);
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here...
    List<Slide> list=slideDao.findAll();
    for (Slide s:list
         ) {
        System.out.println(s.getId());
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


} 
