package blservice.homepageBLService;

import ENUM.UniversalState;
import vo.AccessoryVO;
import vo.NewsVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface NewsBLService {

    //增加一条新闻记录
    public int addNews(NewsVO newsVO);

    //删除一条新闻记录
    public UniversalState deleteNews(int id);

    //更新一条新闻记录
    public UniversalState updateNews(NewsVO newsVO);

    //将新闻记录排序
    public UniversalState sortNews(ArrayList<Integer> list);

    //按日期排序取前五条新闻
    public ArrayList<NewsVO> getFiveNews(String language);

    //取全部新闻
    public ArrayList<NewsVO> getAllNews(String language);


}
