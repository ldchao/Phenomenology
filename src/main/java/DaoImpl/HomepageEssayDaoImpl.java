package DaoImpl;

import Dao.BaseDao;
import Dao.HomepageDao;
import Dao.HomepageEssayDao;
import POJO.Essay;
import POJO.Homepage;
import POJO.HomepageEssay;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class HomepageEssayDaoImpl implements HomepageEssayDao {
    BaseDao baseDao;
    public int pesist(HomepageEssay homepageEssay) {
        baseDao=new BaseDaoImpl();
        HomepageEssay po= (HomepageEssay) baseDao.persist(homepageEssay);
        return po.getId();
    }

    public void delete(int id) {
        baseDao=new BaseDaoImpl();
        HomepageEssay homepageEssay=new HomepageEssay();
        homepageEssay.setId(id);
        baseDao.delete(homepageEssay);
    }

    public void update(HomepageEssay homepageEssay) {
        baseDao=new BaseDaoImpl();
        baseDao.update(homepageEssay);
    }

    public List<HomepageEssay> findAll() {
        baseDao=new BaseDaoImpl();
        return baseDao.findAll("HomepageEssay");
    }


    public HomepageEssay getById(int id) {
        baseDao=new BaseDaoImpl();
        return (HomepageEssay) baseDao.findById(id,HomepageEssay.class);
    }
}
