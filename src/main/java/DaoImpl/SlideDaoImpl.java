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
        try {
            Slide po = (Slide) baseDao.persist(slide);
            return po.getId();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public void delete(int id) {
        Slide slide=new Slide();
        slide.setId(id);
        baseDao.delete(slide);
    }

    public List<Slide> findAll() {
        try {
            return (List<Slide>) baseDao.findAll("Slide");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Slide getById(int id) {
        try {
            return (Slide) baseDao.findById(id,Slide.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
