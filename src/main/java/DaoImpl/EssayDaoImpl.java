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
        try {
            Essay po= (Essay) baseDao.persist(essay);
            return po.getId();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public void delete(int id) {
        baseDao.delete(getById(id));
    }

    public void update(Essay essay) {
        baseDao.update(essay);
    }

    public List<Essay> findAll() {
        try {
            return (List<Essay>)baseDao.findAll("Essay");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Essay> findTop5(Type type, Language language) {
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        List<Essay> result=null;
        try {
           result= (List<Essay>) baseDao.findByPropertiesAndPages("Essay",properties,values,0,5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Essay> find(Type type, Language language) {
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        List<Essay> result=null;
        try {
            result=(List<Essay>) baseDao.findByProperties("Essay",properties,values);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public Essay getById(int id) {
        try {
            return (Essay) baseDao.findById(id,Essay.class);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Essay> getByEssayTitle(String title) {
        String finalString="%";
        for (int i=0;i<title.length();i++){
            finalString+=title.charAt(i);
            finalString+="%";
        }
        String hql="from Essay e where e.title like '"+finalString+"'";
        try {
            return (List<Essay>) baseDao.findByHql(hql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

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
