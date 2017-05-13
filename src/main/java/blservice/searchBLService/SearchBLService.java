package blservice.searchBLService;

import vo.AcademicVO;
import vo.AchievementVO;
import vo.OrganizationVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/8.
 */
public interface SearchBLService {

    //全局搜索文章
    public ArrayList<AcademicVO> searchEssay(String key);

    //根据标签全局搜索文章
    public ArrayList<AcademicVO> searchEssayByTag(String tag);

    //全局搜索科研成果
    public ArrayList<AchievementVO> searchArticle(String key);

    //根据标签全局搜索科研成果
    public ArrayList<AchievementVO> searchArticleByTag(String tag);

    //全局搜索人员
    public ArrayList<OrganizationVO> searchPerson(String key);

    //得到排行前十的热门标签
    public List<String> getHotTags();

}
