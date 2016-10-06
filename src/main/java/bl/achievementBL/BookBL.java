package bl.achievementBL;

import ENUM.UniversalState;
import blservice.achievementBLService.BookBLService;
import vo.AchievementVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/6.
 */
public class BookBL implements BookBLService{
    public int getID() {
        return 0;
    }

    public String addItem(AchievementVO achievementVO) {
        return null;
    }

    public UniversalState deleteItem(int id) {
        return null;
    }

    public UniversalState updateItem(AchievementVO achievementVO) {
        return null;
    }

    public AchievementVO getItem(int id) {
        AchievementVO achievementVO=new AchievementVO();
        achievementVO.setId(0);
        achievementVO.setTitle("ceshi");
        achievementVO.setThumbnailLocation("/test/test.jpg");
        achievementVO.setDescriptionLocation("/test/a.html");
        achievementVO.setTime("2001-1-1");
        return achievementVO;
    }

    public ArrayList<AchievementVO> getAllItems(String language) {
        ArrayList<AchievementVO> result=new ArrayList<AchievementVO>();
        AchievementVO achievementVO=new AchievementVO();
        achievementVO.setId(0);
        achievementVO.setTitle("ceshi");
        achievementVO.setThumbnailLocation("/test/test.jpg");
        achievementVO.setDescriptionLocation("/test/a.html");
        achievementVO.setTime("2001-1-1");
        result.add(achievementVO);

        AchievementVO achievementVO2=new AchievementVO();
        achievementVO2.setId(1);
        achievementVO2.setTitle("ceshi");
        achievementVO2.setThumbnailLocation("/test/test.jpg");
        achievementVO2.setDescriptionLocation("/test/a.html");
        achievementVO2.setTime("2001-1-1");
        result.add(achievementVO2);
        return result;
    }
}
