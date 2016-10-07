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
    public int addNews(NewsVO newsVO);

    //删除一条源头活水记录
    public UniversalState deleteNews(int id);

    //更新一条源头活水记录
    public UniversalState updateNews(NewsVO newsVO);

    //将源头活水记录排序
    public UniversalState sortNews(ArrayList<Integer> list);

    //按日期排序取前五条源头活水记录
    public ArrayList<NewsVO> getFiveNews(String language);

    //取全部源头活水记录
    public ArrayList<NewsVO> getAllNews(String language);


}
