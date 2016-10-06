package DaoImpl;

import Dao.BaseDao;
import Dao.HomepageDao;
import ENUM.Language;
import POJO.Essay;
import POJO.Homepage;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class HomepageDaoImpl implements HomepageDao {
    BaseDao baseDao;
    public static final String ID="id";
    public static final String LANGUAGE="language";
    public static final String TYPE="type";
    public int pesist(Homepage homepage) {
        baseDao=new BaseDaoImpl();
        Homepage po= (Homepage) baseDao.persist(homepage);
        return po.getId();
    }

    public void delete(int id) {
        baseDao=new BaseDaoImpl();
        Homepage homepage=new Homepage();
        homepage.setId(id);
        baseDao.delete(homepage);
    }

    public void update(Homepage homepage) {
        baseDao=new BaseDaoImpl();
        baseDao.update(homepage);
    }

    public List<Homepage> findAll() {
        baseDao=new BaseDaoImpl();
        return (List<Homepage>) baseDao.findAll("Homepage");
    }

    public List<Essay> findTop5(String type, String language) {
        baseDao=new BaseDaoImpl();
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Essay>) baseDao.findByPropertiesAndPages("Essay",properties,values,0,5);
    }

    public List<Essay> find(String type, String language) {
        baseDao=new BaseDaoImpl();
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Essay>) baseDao.findByProperties("Essay",properties,values);
    }

    public Homepage getById(int id) {
        baseDao=new BaseDaoImpl();
        return (Homepage) baseDao.findById(id,Homepage.class);
    }
}
