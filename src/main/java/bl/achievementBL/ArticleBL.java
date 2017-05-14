package bl.achievementBL;

import Dao.ScientificachievementDao;
import DaoImpl.ScientificachievementDaoImpl;
import ENUM.Language;
import ENUM.Type;
import ENUM.UniversalState;
import POJO.Scientificachievement;
import bl.helper.TagManager;
import blservice.achievementBLService.ArticleBLService;
import vo.AchievementVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/6.
 */
public class ArticleBL implements ArticleBLService{
    public int getID() {
        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        Scientificachievement scientificachievement=new Scientificachievement();
        return scientificachievementDao.pesist(scientificachievement);
    }

    public String addItem(AchievementVO achievementVO) {
        return null;
    }

    public UniversalState deleteItem(int id) {
        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        scientificachievementDao.delete(id);
        return UniversalState.SUCCEED;
    }

    public UniversalState updateItem(AchievementVO achievementVO) {
        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        Scientificachievement scientificachievement=new Scientificachievement();
        scientificachievement.setId(achievementVO.getId());
        scientificachievement.setTitle(achievementVO.getTitle());
        scientificachievement.setTime(new Date());
        scientificachievement.setType(Type.Article);
        scientificachievement.setLanguage(Language.valueOf(achievementVO.getLanguage()));
        scientificachievement.setDescriptionLocation(achievementVO.getDescriptionLocation());
        scientificachievement.setThumbnailLocation(achievementVO.getThumbnailLocation());
        scientificachievementDao.update(scientificachievement);
        TagManager.updateSaTags(achievementVO.getId(),achievementVO.getTags());
        return UniversalState.SUCCEED;
    }

    public AchievementVO getItem(int id) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        Scientificachievement scientificachievement=scientificachievementDao.getById(id);
        AchievementVO achievementVO=new AchievementVO();
        achievementVO.update(scientificachievement);
        achievementVO.setTags(TagManager.getSaTags(scientificachievement.getId()));
        return achievementVO;
    }

    public ArrayList<AchievementVO> getAllItems(String language) {
        ArrayList<AchievementVO> result=new ArrayList<AchievementVO>();

        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        List<Scientificachievement> scientificachievements=scientificachievementDao.find(Type.Article,Language.valueOf(language));
        for (Scientificachievement scientificachievement:scientificachievements) {
            AchievementVO achievementVO=new AchievementVO();
            achievementVO.update(scientificachievement);
            // TODO: 2017/5/14
            result.add(achievementVO);
        }
        return result;
    }
}
