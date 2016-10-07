package bl.homepageBL;

import Dao.SlideDao;
import DaoImpl.SlideDaoImpl;
import ENUM.UniversalState;
import POJO.Slide;
import blservice.homepageBLService.CarouselFigureBLService;
import vo.PictureVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/4.
 */
public class CarouselFigureBL implements CarouselFigureBLService{

    public int addAPicture(PictureVO pictureVO) {
        SlideDao slideDao=new SlideDaoImpl();
        Slide slide=new Slide();
        slide.setLocation(pictureVO.getLocation());
//        slide.set
        return slideDao.pesist(slide);
    }

    public ArrayList<PictureVO> getAllPicture() {
        SlideDao slideDao=new SlideDaoImpl();
        List<Slide> list=slideDao.findAll();
        ArrayList<PictureVO> result=new ArrayList<PictureVO>();
        for (Slide slide:list) {
            PictureVO pictureVO=new PictureVO();
            pictureVO.setId(slide.getId());
            pictureVO.setLocation(slide.getLocation());
            result.add(pictureVO);
        }
        return result;
    }

    public UniversalState deleteAPicture(int id) {
        SlideDao slideDao=new SlideDaoImpl();
        slideDao.delete(id);
        return UniversalState.SUCCEED;
    }
}
