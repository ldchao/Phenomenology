package blservice.searchBLService;

import vo.AcademicVO;
import vo.AchievementVO;
import vo.OrganizationVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/8.
 */
public interface SearchBLService {

    //全局搜索文章
    public ArrayList<AcademicVO> searchEssay(String key);

    //全局搜索科研成果
    public ArrayList<AchievementVO> searchArticle(String key);

    //全局搜索人员
    public ArrayList<OrganizationVO> searchPerson(String key);

}
