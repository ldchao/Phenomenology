package bl.helper;

import Dao.EssayTagDao;
import Dao.SaTagDao;
import DaoImpl.EssayTagImpl;
import DaoImpl.SaTagImpl;
import POJO.EssayTag;
import POJO.SaTag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ldchao on 2017/5/14.
 */
public class TagManager {
    public static List<String> tagToString(List<EssayTag> tags){
        List<String> result=new ArrayList<String>();
        for (EssayTag essayTag:tags) {
            result.add(essayTag.getTagName());
        }
        return result;
    }

    public static List<String> getEssayTags(int essayId){
        EssayTagDao essayTagDao=new EssayTagImpl();
        List<String> result=new ArrayList<String>();
        List<EssayTag> tags=essayTagDao.getEssayTagsByEssayId(essayId);
        for (EssayTag essayTag:tags) {
            result.add(essayTag.getTagName());
        }
        return result;
    }

    public static void updateEssayTags(int id, List<String> tags){
        EssayTagDao essayTagDao=new EssayTagImpl();
        essayTagDao.deleteByEssayId(id);
        Set<String> set=new HashSet<String>(tags);
        essayTagDao.addRelations(id,new ArrayList<String>(set));
    }

    public static List<String> getSaTags(int saId){
        SaTagDao saTagDao=new SaTagImpl();
        List<String> result=new ArrayList<String>();
        List<SaTag> tags=saTagDao.getSaTagsByScientificAchievementId(saId);
        for (SaTag saTag:tags) {
            result.add(saTag.getTagName());
        }
        return result;
    }

    public static void updateSaTags(int id, List<String> tags){
        SaTagDao saTagDao=new SaTagImpl();
        saTagDao.deleteByScientificAchievementId(id);
        Set<String> set=new HashSet<String>(tags);
        saTagDao.addRelations(id,new ArrayList<String>(set));
    }
}
