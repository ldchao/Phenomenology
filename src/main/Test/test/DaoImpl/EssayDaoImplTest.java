package test.DaoImpl; 

import Dao.EssayDao;
import DaoImpl.EssayDaoImpl;
import ENUM.Language;
import ENUM.Type;
import POJO.Essay;
import org.hibernate.hql.internal.ast.tree.SearchedCaseNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Calendar;

/** 
* EssayDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ�� 6, 2016</pre> 
* @version 1.0 
*/ 
public class EssayDaoImplTest {
    Essay essay;
    EssayDao essayDao;
@Before
public void before() throws Exception {
    essayDao=new EssayDaoImpl();
    essay=new Essay();
//    essay.setAuthor("shabichao");
//    essay.setLanguage(Language.CHINESE);
//    essay.setTime(Calendar.getInstance().getTime());
//    essay.setTitle("");
//    essay.setType(Type.Article);
//    essay.setLocation("");
}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: pesist(Essay essay) 
* 
*/ 
@Test
public void testPesist() throws Exception { 
//TODO: Test goes here...
    essayDao.pesist(essay);
    System.out.println();
}

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here...
    essayDao.delete(3);
} 

/** 
* 
* Method: update(Essay essay) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here...
    Essay po=essayDao.getById(4);
    po.setTime(Calendar.getInstance().getTime());
    essayDao.update(po);
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here...
    System.out.println(essayDao.findAll().size());
} 

/** 
* 
* Method: findTop5(String type, String Language) 
* 
*/ 
@Test
public void testFindTop5() throws Exception { 
//TODO: Test goes here...
    System.out.println(essayDao.findTop5(Type.UNKNOWN,Language.eng).size());
} 

/** 
* 
* Method: find(String type, String language) 
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
    Essay po=essayDao.getById(3);
    System.out.println(po.getLanguage());
} 


} 
