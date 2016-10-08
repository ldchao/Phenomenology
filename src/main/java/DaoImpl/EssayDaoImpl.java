package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.EssayDao;
import ENUM.Language;
import ENUM.Type;
import POJO.Essay;
import POJO.EssayAttachment;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public EssayDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public int pesist(Essay essay) {
        Essay po= (Essay) baseDao.persist(essay);
        return po.getId();
    }

    public void delete(int id) {
        Essay essay=new Essay();
        essay.setId(id);
        baseDao.delete(essay);
    }

    public void update(Essay essay) {
        baseDao.update(essay);
    }

    public List<Essay> findAll() {
        return (List<Essay>)baseDao.findAll("Essay");
    }

    public List<Essay> findTop5(Type type, Language language) {
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Essay>) baseDao.findByPropertiesAndPages("Essay",properties,values,0,5);
    }

    public List<Essay> find(Type type, Language language) {
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Essay>) baseDao.findByProperties("Essay",properties,values);
    }

    public Essay getById(int id) {
        return (Essay) baseDao.findById(id,Essay.class);
    }

    public List<Essay> getByEssayTitle(String title) {
        String[] properties={TITLE};
        Object[] values={title};
        return (List<Essay>) baseDao.findByProperties("Essay",properties,values);
    }

    public Set<EssayAttachment> getByEssayAttachment(int id) {
        Session session=DBconnection.getSession();
        Set<EssayAttachment> result=new HashSet<EssayAttachment>();
        try {
            Essay essay=session.get(Essay.class,id);
            result.addAll(essay.getEssayAttachments());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBconnection.closeSession(session);
        }
        return result;
    }
}
