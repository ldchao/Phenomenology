package test.DaoImpl; 

import Dao.BaseDao;
import DaoImpl.BaseDaoImpl;
import POJO.Essay;
import POJO.EssayAttachment;
import POJO.Homepage;
import POJO.HomepageEssay;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* BaseDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮһ�� 1, 2016</pre> 
* @version 1.0 
*/ 
public class BaseDaoImplTest { 
BaseDao baseDao;
@Before
public void before() throws Exception {
    baseDao=new BaseDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: persist(Object bean) 
* 
*/ 
@Test
public void testPersist() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(Object bean) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here...
//    Essay essay=new Essay();
//    essay.setId(45);
//    EssayAttachment essay=new EssayAttachment();
    HomepageEssay essay=new HomepageEssay();
    essay.setId(68);
    baseDao.delete(essay);
} 

/** 
* 
* Method: update(Object bean) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findById(int i, Class clazz) 
* 
*/ 
@Test
public void testFindById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findByHql(String hql) 
* 
*/ 
@Test
public void testFindByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll(String tableName) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findByProperties(String tableName, String[] name, Object[] values) 
* 
*/ 
@Test
public void testFindByProperties() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findByPage(String tableName, int page, int pageSize) 
* 
*/ 
@Test
public void testFindByPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findByPropertiesAndPages(String tableName, String[] name, Object[] values, int page, int pageSize) 
* 
*/ 
@Test
public void testFindByPropertiesAndPages() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: clean(String tableName) 
* 
*/ 
@Test
public void testClean() throws Exception { 
//TODO: Test goes here... 
} 


} 
