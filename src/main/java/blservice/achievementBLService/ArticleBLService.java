package blservice.achievementBLService;

import ENUM.UniversalState;
import vo.AchievementVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface ArticleBLService {

    //增加一条文章发表记录
    public String addItem(AchievementVO achievementVO);

    //增加一条文章发表附件添加记录
    public String addAccessory(AchievementVO achievementVO);

    //删除一条文章发表的记录
    public UniversalState deleteItem(int id);

    //更新一条文章发表的记录
    public UniversalState updateItem(AchievementVO achievementVO);

    //获取全部文章发表的记录
    public ArrayList<AchievementVO> getAllItems(String language);



}
