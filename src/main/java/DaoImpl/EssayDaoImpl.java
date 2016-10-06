package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.EssayDao;
import ENUM.Language;
import ENUM.Type;
import POJO.Essay;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class EssayDaoImpl implements EssayDao {
    BaseDao baseDao;
    public static final String ID="id";
    public static final String TITLE="title";
    public static final String TIME="time";
    public static final String AUTHOR="author";
    public static final String LOCATION="location";
    public static final String LANGUAGE="language";
    public static final String  PAGEVIEW="pageView";
    public static final String TYPE="type";

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

    public List<Essay> findTop5(Type type, Language language) {
        baseDao=new BaseDaoImpl();
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Essay>) baseDao.findByPropertiesAndPages("Essay",properties,values,0,5);
    }

    public List<Essay> find(Type type, Language language) {
        baseDao=new BaseDaoImpl();
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Essay>) baseDao.findByProperties("Essay",properties,values);
    }

    public Essay getById(int id) {
        baseDao=new BaseDaoImpl();
        return (Essay) baseDao.findById(id,Essay.class);
    }
}
