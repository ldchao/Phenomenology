package bl.searchBL;

import Dao.*;
import DaoImpl.*;
import POJO.*;
import bl.helper.TagManager;
import blservice.searchBLService.SearchBLService;
import vo.AcademicVO;
import vo.AchievementVO;
import vo.OrganizationVO;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lvdechao on 2016/10/8.
 */
public class SearchBL implements SearchBLService{
    public ArrayList<AcademicVO> searchEssay(String key) {
        EssayDao essayDao=new EssayDaoImpl();
        List<Essay> essays=essayDao.getByEssayTitle(key);
        ArrayList<AcademicVO> result=new ArrayList<AcademicVO>();
        for (Essay essay:essays) {
            AcademicVO academicVO=new AcademicVO();
            academicVO.update(essay);
            // TODO: 2017/5/14
            result.add(academicVO);
        }
        return result;
    }

    public ArrayList<AchievementVO> searchArticle(String key) {

        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        List<Scientificachievement> scientificachievements=scientificachievementDao.getBySaTitle(key);
        ArrayList<AchievementVO> result=new ArrayList<AchievementVO>();
        for (Scientificachievement scientificachievement:scientificachievements) {
            AchievementVO achievementVO=new AchievementVO();
            achievementVO.update(scientificachievement);
            // TODO: 2017/5/14  
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

        EssayDao essayDao=new EssayDaoImpl();
        List<Essay> essays=essayDao.getEssaysByEssayTag(tag);
        ArrayList<AcademicVO> result=new ArrayList<AcademicVO>();
        for (Essay essay:essays) {
            AcademicVO academicVO=new AcademicVO();
            academicVO.update(essay);
            // TODO: 2017/5/14 academicVO.setTags(TagManager.getEssayTags(essay.getId()));
            result.add(academicVO);
        }
        EssayTagDao essayTagDao=new EssayTagImpl();
        essayTagDao.AddEssayTag_Views(tag);
        return result;
    }

    public ArrayList<AchievementVO> searchArticleByTag(String tag) {
        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        List<Scientificachievement> scientificachievements=scientificachievementDao.getScientificAchievementBySaTag(tag);
        ArrayList<AchievementVO> result=new ArrayList<AchievementVO>();
        for (Scientificachievement scientificachievement:scientificachievements) {
            AchievementVO achievementVO=new AchievementVO();
            achievementVO.update(scientificachievement);
            // TODO: 2017/5/14   achievementVO.setTags(TagManager.getSaTags(scientificachievement.getId()));
            result.add(achievementVO);
        }
        SaTagDao saTagDao=new SaTagImpl();
        saTagDao.addSaTag_Views(tag);
        return result;
    }


    public List<String> getHotTags() {
        EssayTagDao essayTagDao=new EssayTagImpl();
        SaTagDao saTagDao=new SaTagImpl();
        List<SaTag> saTags=saTagDao.getSaTagsOfTop10();
        List<EssayTag> essayTags=essayTagDao.getEssayTagsOfTop10();

       List<String> result=new ArrayList<String>();
       int saIndex=0;
       int essayIndex=0;
       while(result.size()<10&&saIndex<saTags.size()&&essayIndex<essayTags.size()){
           SaTag saTag=saTags.get(saIndex);
           EssayTag essayTag=essayTags.get(essayIndex);
           if(result.contains(saTag.getTagName())){
               saIndex++;
           }else if(result.contains(essayTag.getTagName())){
               essayIndex++;
           }else{
              if(saTag.getViews()>=essayTag.getViews()){
                   result.add(saTag.getTagName());
                   saIndex++;
              }else if(saTag.getViews()<essayTag.getViews()){
                   result.add(essayTag.getTagName());
                   essayIndex++;
              }
           }
       }
       if(result.size()<10){
           if(saIndex<saTags.size()){
               while (result.size()<10&&saIndex<saTags.size()){
                   SaTag saTag=saTags.get(saIndex);
                   result.add(saTag.getTagName());
                   saIndex++;
               }
           }else if(essayIndex<essayTags.size()){
               while (result.size()<10&&essayIndex<essayTags.size()){
                   EssayTag essayTag=essayTags.get(saIndex);
                   result.add(essayTag.getTagName());
                   essayIndex++;
               }
           }
       }
        return result;
    }


}

