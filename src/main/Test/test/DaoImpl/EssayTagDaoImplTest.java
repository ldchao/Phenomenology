package test.DaoImpl;

import Dao.EssayTagDao;
import DaoImpl.EssayTagImpl;
import POJO.EssayTag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2017/5/14.
 */
public class EssayTagDaoImplTest {
    EssayTagDao essayTagDao=new EssayTagImpl();
    @Test
    public void getEssayTagsByEssayId(){
        System.out.println(essayTagDao.getEssayTagsByEssayId(70).size());
        System.out.println(essayTagDao.getEssayTagsByEssayId(0).size());
        System.out.println(essayTagDao.getEssayTagsByEssayId(102).size());
    }

    @Test
    public void AddEssayTag_Views(){
        essayTagDao.AddEssayTag_Views("123");
    }

    @Test
    public void getEssayTagsOfTop10(){
        List<EssayTag> list=essayTagDao.getEssayTagsOfTop10();
        for (EssayTag e :
                list) {
            System.out.println(e.getTagName());
        }
    }

    @Test
    public void addRelations(){
//        essayTagDao.addRelations(103,"cc");
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("0");
        arrayList.add("11");
        arrayList.add("qqq");
        essayTagDao.addRelations(102,arrayList);
    }

    @Test
    public void deleteByEssayIdAndTagName(){
        essayTagDao.deleteByEssayIdAndTagName(102,"cc");
    }

    @Test
    public void deleteByEssayId(){
        essayTagDao.deleteByEssayId(102);
    }
}
