package test.DaoImpl; 

import Connection.DBconnection;
import Dao.BaseDao;
import DaoImpl.BaseDaoImpl;
import DaoImpl.EssayDaoImpl;
import ENUM.Language;
import ENUM.Type;

import POJO.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import javax.swing.text.html.HTML;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


@Test
    public void test1() {
        EssayDaoImpl essayDao=new EssayDaoImpl();
        Essay essay=essayDao.getById(102);
        Session session=DBconnection.getSession();
//        String hql="from EssayTag";
//        List<EssayTag> list=session.createQuery(hql).list();
//        list.get(0).getEssays().add(essay);
//        list.get(1).getEssays().add(essay);
//        session.update(list.get(0));
//        session.update(list.get(1));
    Scientificachievement sc=session.get(Scientificachievement.class,2);
    String hql="from SaTag";
    List<SaTag> saTags=session.createQuery(hql).list();
    saTags.get(0).getScientificachievements().add(sc);
    saTags.get(1).getScientificachievements().add(sc);
    session.save(saTags.get(0));
    session.save(saTags.get(1));
        Transaction ts=session.beginTransaction();
        ts.commit();
        session.close();
    }
} 
