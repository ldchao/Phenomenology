package DaoImpl;

import Dao.BaseDao;
import Dao.HomepageDao;
import ENUM.Language;
import ENUM.Type;
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

    public HomepageDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public int pesist(Homepage homepage) {
        Homepage po= (Homepage) baseDao.persist(homepage);
        return po.getId();
    }

    public void delete(int id) {
        Homepage homepage=new Homepage();
        homepage.setId(id);
        baseDao.delete(homepage);
    }

    public void update(Homepage homepage) {
        baseDao.update(homepage);
    }

    public List<Homepage> findAll() {
        return (List<Homepage>) baseDao.findAll("Homepage");
    }


    public Homepage getById(int id) {
        return (Homepage) baseDao.findById(id,Homepage.class);
    }

    public Homepage getByTypeAndLanguage(Type type, Language language) {
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        Homepage homepage= null;
        try {
            homepage=(Homepage) baseDao.findByProperties("Homepage",properties,values).get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return homepage;
    }
}
