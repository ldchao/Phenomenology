package bl.homepageBL;

import Dao.HomepageDao;
import Dao.HomepageEssayDao;
import DaoImpl.HomepageDaoImpl;
import DaoImpl.HomepageEssayDaoImpl;
import ENUM.Language;
import ENUM.Type;
import ENUM.UniversalState;
import POJO.Homepage;
import POJO.HomepageEssay;
import blservice.homepageBLService.NewsBLService;
import vo.NewsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/7.
 */
public class NewsBL implements NewsBLService{
    public int addNews(NewsVO newsVO) {
        HomepageEssayDao homepageEssayDao=new HomepageEssayDaoImpl();
        HomepageEssay homepageEssay=new HomepageEssay();
        homepageEssay.setUrl(newsVO.getUrl());
        homepageEssay.setThumbnailLocation(newsVO.getThumbnailLocation());
        HomepageDao homepageDao=new HomepageDaoImpl();
        Homepage homepageID=homepageDao.getByTypeAndLanguage(Type.DYNAMIC_NEWS, Language.valueOf(newsVO.getLanguage()));
        Homepage homepage=new Homepage();
        homepage.setId(homepageID.getId());
        homepageEssay.setHomepage(homepage);
        return homepageEssayDao.pesist(homepageEssay);
    }

    public UniversalState deleteNews(int id) {

        HomepageEssayDao homepageEssayDao=new HomepageEssayDaoImpl();
        homepageEssayDao.delete(id);
        return UniversalState.SUCCEED;
    }

    public UniversalState updateNews(NewsVO newsVO) {
        HomepageEssayDao homepageEssayDao=new HomepageEssayDaoImpl();
        HomepageEssay homepageEssay=homepageEssayDao.getById(newsVO.getId());
        homepageEssay.setUrl(newsVO.getUrl());
        homepageEssay.setThumbnailLocation(newsVO.getThumbnailLocation());
        HomepageDao homepageDao=new HomepageDaoImpl();
        Homepage homepageID=homepageDao.getByTypeAndLanguage(Type.DYNAMIC_NEWS, Language.valueOf(newsVO.getLanguage()));
        Homepage homepage=new Homepage();
        homepage.setId(homepageID.getId());
        homepageEssay.setHomepage(homepage);
        homepageEssayDao.update(homepageEssay);
        return UniversalState.SUCCEED;
    }

    public UniversalState sortNews(ArrayList<Integer> list) {
        HomepageEssayDao homepageEssayDao=new HomepageEssayDaoImpl();
//        homepageEssayDao.rank(list);
        return null;
    }

    public ArrayList<NewsVO> getFiveNews(String language) {
        ArrayList<NewsVO> list=new ArrayList<NewsVO>();
        HomepageEssayDao homepageEssayDao=new HomepageEssayDaoImpl();
        HomepageDao homepageDao=new HomepageDaoImpl();
        Homepage homepageID=homepageDao.getByTypeAndLanguage(Type.DYNAMIC_NEWS, Language.valueOf(language));
        List<HomepageEssay> homepageEssays = homepageEssayDao.findAll(homepageID.getId());
        // TODO: 2016/10/7  取前五个
        for (HomepageEssay homepageEssay:homepageEssays) {
            NewsVO newsVO=new NewsVO();
            newsVO.setId(homepageEssay.getId());
            newsVO.setLanguage(language);
            newsVO.setUrl(homepageEssay.getUrl());
            newsVO.setThumbnailLocation(homepageEssay.getThumbnailLocation());
            list.add(newsVO);
        }
        return list;
    }

    public ArrayList<NewsVO> getAllNews(String language) {
        ArrayList<NewsVO> list=new ArrayList<NewsVO>();
        HomepageEssayDao homepageEssayDao=new HomepageEssayDaoImpl();
        HomepageDao homepageDao=new HomepageDaoImpl();
        Homepage homepageID=homepageDao.getByTypeAndLanguage(Type.DYNAMIC_NEWS, Language.valueOf(language));
        List<HomepageEssay> homepageEssays = homepageEssayDao.findAll(homepageID.getId());
        for (HomepageEssay homepageEssay:homepageEssays) {
            NewsVO newsVO=new NewsVO();
            newsVO.setId(homepageEssay.getId());
            newsVO.setLanguage(language);
            newsVO.setUrl(homepageEssay.getUrl());
            newsVO.setThumbnailLocation(homepageEssay.getThumbnailLocation());
            list.add(newsVO);
        }
        return list;
    }
}
