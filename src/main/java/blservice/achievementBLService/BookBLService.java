package blservice.achievementBLService;

import ENUM.UniversalState;
import vo.AcademicVO;
import vo.AccessoryVO;
import vo.AchievementVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface BookBLService {

    //得到一个新的id
    public int getID();

    //增加一条书籍出版记录
    public String addItem(AchievementVO achievementVO);

    //删除一条书籍出版的记录
    public UniversalState deleteItem(int id);

    //更新一条书籍出版的记录
    public UniversalState updateItem(AchievementVO achievementVO);

    //获取一条书籍出版的记录
    public AchievementVO getItem(int id);

    //获取全部书籍出版的记录
    public ArrayList<AchievementVO> getAllItems(String language);



}
