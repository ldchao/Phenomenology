package DaoImpl;

import Dao.BaseDao;
import Dao.SlideDao;
import POJO.Slide;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class SlideDaoImpl implements SlideDao {
    BaseDao baseDao;

    public SlideDaoImpl(){
        baseDao=new BaseDaoImpl();
    }


    public int pesist(Slide slide) {
        Slide po= (Slide) baseDao.persist(slide);
        return po.getId();
    }

    public void delete(int id) {
        Slide slide=new Slide();
        slide.setId(id);
        baseDao.delete(slide);
    }

    public List<Slide> findAll() {
        return (List<Slide>) baseDao.findAll("Slide");
    }

    public Slide getById(int id) {
        return (Slide) baseDao.findById(id,Slide.class);
    }
}
