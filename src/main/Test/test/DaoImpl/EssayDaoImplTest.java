package test.DaoImpl; 

import Dao.EssayDao;
import DaoImpl.EssayDaoImpl;
import ENUM.Language;
import ENUM.Type;
import POJO.Essay;
import POJO.EssayAttachment;
import org.hibernate.hql.internal.ast.tree.SearchedCaseNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

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
    essayDao.delete(2);
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
    List<Essay> list=essayDao.findAll();
    for (Essay essay:
            list
         ) {
        System.out.println(essay.getId());
    }

} 

/** 
* 
* Method: findTop5(String type, String Language) 
* 
*/ 
@Test
public void testFindTop5() throws Exception { 
//TODO: Test goes here...
    List<Essay> list=essayDao.findTop5(Type.UNKNOWN,Language.ch);
    for (Essay essay:
            list
            ) {
        System.out.println(essay.getId());
    }
} 

/** 
* 
* Method: find(String type, String language) 
* 
*/ 
@Test
public void testFind() throws Exception { 
//TODO: Test goes here...
    List<Essay> list=essayDao.find(Type.UNKNOWN,Language.ch);
    for (Essay essay:
            list
            ) {
        System.out.println(essay.getId());
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
    Set<EssayAttachment> po=essayDao.getByEssayAttachment(2);
    for (EssayAttachment essayAttachment:po){
        System.out.println(essayAttachment.getTitle());

    }
}

@Test
    public void findByTitle() throws Exception{
    System.out.println(essayDao.getByEssayTitle("unknown").size());
}
} 
