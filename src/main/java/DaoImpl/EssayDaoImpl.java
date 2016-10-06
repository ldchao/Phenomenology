package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.EssayDao;
import POJO.Essay;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class EssayDaoImpl implements EssayDao {
    BaseDao baseDao;
    public int pesist(Essay essay) {
        baseDao=new BaseDaoImpl();
        Essay po= (Essay) baseDao.persist(essay);
        return po.getId();
    }

    public void delete(int id) {
        baseDao=new BaseDaoImpl();
        Essay essay=new Essay();
        essay.setId(id);
        baseDao.delete(essay);
    }

    public void update(Essay essay) {
        baseDao=new BaseDaoImpl();
        baseDao.update(essay);
    }

    public List<Essay> findAll() {
        baseDao=new BaseDaoImpl();
        return (List<Essay>)baseDao.findAll("Essay");
    }

    public List<Essay> findTop5(String type, String Language) {
        baseDao=new BaseDaoImpl();
        return null;
    }

    public List<Essay> find(String type, String language) {
        baseDao=new BaseDaoImpl();
        return null;
    }

    public Essay getById(int id) {
        baseDao=new BaseDaoImpl();
        return (Essay) baseDao.findById(id,Essay.class);
    }
}
