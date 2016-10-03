package blservice.homepageBLService;

import ENUM.UniversalState;
import vo.AccessoryVO;
import vo.NewsVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface FountainheadBLService {

    //增加一条源头活水记录
    public String addNews(NewsVO newsVO);

    //增加一条源头活水附件添加记录
    public String addAccessory(AccessoryVO accessoryVO);

    //删除一条源头活水记录
    public UniversalState deleteNews(String id);

    //按日期排序取前五条源头活水记录
    public ArrayList<NewsVO> getFiveNews(String language);

    //取全部源头活水记录
    public ArrayList<NewsVO> getAllNews(String language);


}
