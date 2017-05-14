package test.DaoImpl;

import Dao.SaTagDao;
import DaoImpl.SaTagImpl;
import POJO.SaTag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2017/5/14.
 */
public class SaTagDaoImplTest {
    SaTagDao saTagDao=new SaTagImpl();
    @Test
    public void getSaTagsByScientificAchievementId(){
        System.out.println(saTagDao.getSaTagsByScientificAchievementId(1).size());
        System.out.println(saTagDao.getSaTagsByScientificAchievementId(2).size());
        System.out.println(saTagDao.getSaTagsByScientificAchievementId(3).size());
    }

    @Test
    public void addSaTag_Views(){
        saTagDao.addSaTag_Views("123");
        saTagDao.addSaTag_Views("ddd");
        saTagDao.addSaTag_Views("12");
    }

    @Test
    public void getSaTagsOfTop10(){
        List<SaTag> list=saTagDao.getSaTagsOfTop10();
        for (SaTag s:list){
            System.out .println(s.getTagName());
        }
    }

    @Test
    public void addRelations(){
//        saTagDao.addRelations(1,"123");
//        saTagDao.addRelations(1,"ddd");
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("123");
        saTagDao.addRelations(2,arrayList);

    }

    @Test
    public void deleteByScientificAchievementIdAndTagName(){
        saTagDao.deleteByScientificAchievementIdAndTagName(1,"123");
        saTagDao.deleteByScientificAchievementIdAndTagName(1,"ddd");

        saTagDao.deleteByScientificAchievementIdAndTagName(1,"4");
    }


    @Test
    public void deleteByScientificAchievementId(){
        saTagDao.deleteByScientificAchievementId(1);
    }
}
