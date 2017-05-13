package bl.searchBL;

import Dao.EssayDao;
import Dao.PersonDao;
import Dao.ScientificachievementDao;
import DaoImpl.EssayDaoImpl;
import DaoImpl.PersonDaoImpl;
import DaoImpl.ScientificachievementDaoImpl;
import POJO.Essay;
import POJO.Person;
import POJO.Scientificachievement;
import blservice.searchBLService.SearchBLService;
import vo.AcademicVO;
import vo.AchievementVO;
import vo.OrganizationVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/8.
 */
public class SearchBL implements SearchBLService{
    public ArrayList<AcademicVO> searchEssay(String key) {
        EssayDao essayDao=new EssayDaoImpl();
        List<Essay> essays=essayDao.getByEssayTitle(key);
        ArrayList<AcademicVO> result=new ArrayList<AcademicVO>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for (Essay essay:essays) {
            AcademicVO academicVO=new AcademicVO();
            academicVO.setId(essay.getId());
            academicVO.setAuthor(essay.getAuthor());
            academicVO.setLocation(essay.getLocation());
            academicVO.setTitle(essay.getTitle());
            academicVO.setPageView(essay.getPageView());
            academicVO.setTime(sdf.format(essay.getTime()));
            result.add(academicVO);
        }
        return result;
    }

    public ArrayList<AchievementVO> searchArticle(String key) {

        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        List<Scientificachievement> scientificachievements=scientificachievementDao.getBySaTitle(key);
        ArrayList<AchievementVO> result=new ArrayList<AchievementVO>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for (Scientificachievement scientificachievement:scientificachievements) {
            AchievementVO achievementVO=new AchievementVO();
            achievementVO.setId(scientificachievement.getId());
            achievementVO.setTitle(scientificachievement.getTitle());
            achievementVO.setThumbnailLocation(scientificachievement.getThumbnailLocation());
            achievementVO.setDescriptionLocation(scientificachievement.getDescriptionLocation());
            achievementVO.setTime(sdf.format(scientificachievement.getTime()));
            result.add(achievementVO);
        }
        return result;
    }

    public ArrayList<OrganizationVO> searchPerson(String key) {
        PersonDao personDao=new PersonDaoImpl();
        List<Person> persons=personDao.getByPersonName(key);
        ArrayList<OrganizationVO> result=new ArrayList<OrganizationVO>();

        for (Person person:persons) {
            OrganizationVO organizationVO=new OrganizationVO();
            organizationVO.setId(person.getId());
            organizationVO.setName(person.getName());
            organizationVO.setDescriptionLocation(person.getDescriptionLocation());
            organizationVO.setImageLocation(person.getImageLocation());
            result.add(organizationVO);
        }
        return result;
    }

    public ArrayList<AcademicVO> searchEssayByTag(String tag) {
        return null;
    }

    public ArrayList<AchievementVO> searchArticleByTag(String tag) {
        return null;
    }

    public List<String> getHotTags() {
        return null;
    }
}
