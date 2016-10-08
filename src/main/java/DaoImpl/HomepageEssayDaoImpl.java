package DaoImpl;

import Dao.BaseDao;
import Dao.HomepageDao;
import Dao.HomepageEssayDao;
import POJO.Essay;
import POJO.Homepage;
import POJO.HomepageEssay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class HomepageEssayDaoImpl implements HomepageEssayDao {
    BaseDao baseDao;
    public HomepageEssayDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public int pesist(HomepageEssay homepageEssay) {
        HomepageEssay po= (HomepageEssay) baseDao.persist(homepageEssay);
        return po.getId();
    }

    public void delete(int id) {
        HomepageEssay homepageEssay=new HomepageEssay();
        homepageEssay.setId(id);
        baseDao.delete(homepageEssay);
    }

    public void update(HomepageEssay homepageEssay) {
        baseDao.update(homepageEssay);
    }

    public List<HomepageEssay> findAll(int i) {
        String hql="from HomepageEssay h where h.homepage.id="+i;
        return (List<HomepageEssay>) baseDao.findByHql(hql);
    }


    public HomepageEssay getById(int id) {
        return (HomepageEssay) baseDao.findById(id,HomepageEssay.class);
    }

    public void rank(ArrayList<HomepageEssay> homepageEssays) {
        baseDao.clean("HomepageEssay");
    }
}
