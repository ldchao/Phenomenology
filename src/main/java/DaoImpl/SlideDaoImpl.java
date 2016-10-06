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
    public int pesist(Slide slide) {
        baseDao=new BaseDaoImpl();
        Slide po= (Slide) baseDao.persist(slide);
        return po.getId();
    }

    public void delete(int id) {
        baseDao=new BaseDaoImpl();
        Slide slide=new Slide();
        slide.setId(id);
        baseDao.delete(slide);
    }

    public List<Slide> findAll() {
        baseDao=new BaseDaoImpl();
        return (List<Slide>) baseDao.findAll("Slide");
    }

    public Slide getById(int id) {
        baseDao=new BaseDaoImpl();
        return (Slide) baseDao.findById(id,Slide.class);
    }
}
