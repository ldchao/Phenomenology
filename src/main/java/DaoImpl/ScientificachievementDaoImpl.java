package DaoImpl;

import Dao.BaseDao;
import Dao.ScientificachievementDao;
import POJO.Scientificachievement;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class ScientificachievementDaoImpl implements ScientificachievementDao {
    BaseDao baseDao;
    public static final String ID="id";
    public static final String TITLE="title";
    public static final String TYPE="type";
    public static final String LANGUAGE="language";
    public static final String THUMBNAIL_LOCATION="thumbnailLocation";
    public static final String DESCRIPTION_LOCATION="descriptionLocation";
    public static final String TIME="time";
    public int pesist(Scientificachievement scientificachievement) {
        baseDao=new BaseDaoImpl();
        Scientificachievement po= (Scientificachievement) baseDao.persist(scientificachievement);
        return po.getId();
    }

    public void delete(int id) {
        baseDao=new BaseDaoImpl();
        Scientificachievement scientificachievement=new Scientificachievement();
        scientificachievement.setId(id);
        baseDao.delete(scientificachievement);
    }

    public void update(Scientificachievement scientificachievement) {
        baseDao=new BaseDaoImpl();
        baseDao.update(scientificachievement);
    }

    public List<Scientificachievement> findAll() {
        baseDao=new BaseDaoImpl();
        return (List<Scientificachievement>) baseDao.findAll("Scientificachievement");
    }

    public List<Scientificachievement> find(String type, String language) {
        baseDao=new BaseDaoImpl();
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Scientificachievement>) baseDao.findByProperties("Scientificachievement",properties,values);
    }

    public Scientificachievement getById(int id) {
        baseDao=new BaseDaoImpl();
        return (Scientificachievement) baseDao.findById(id,Scientificachievement.class);
    }
}
