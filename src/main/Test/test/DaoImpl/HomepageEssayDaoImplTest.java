package test.DaoImpl; 

import Dao.HomepageEssayDao;
import DaoImpl.HomepageEssayDaoImpl;
import POJO.HomepageEssay;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* HomepageEssayDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ�� 7, 2016</pre> 
* @version 1.0 
*/ 
public class HomepageEssayDaoImplTest { 
HomepageEssayDao homepageEssayDao;
@Before
public void before() throws Exception {
    homepageEssayDao=new HomepageEssayDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: pesist(HomepageEssay homepageEssay) 
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
* Method: update(HomepageEssay homepageEssay) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll(int i) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here...
    System.out.println(homepageEssayDao.findAll(3).size());
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
* Method: rank(ArrayList<HomepageEssay> homepageEssays) 
* 
*/ 
@Test
public void testRank() throws Exception { 
//TODO: Test goes here...
//    homepageEssayDao.rank();
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(1);
    homepageEssayDao.rank(arrayList);
    System.out.print("yes");
} 


} 