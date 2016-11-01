package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.ScientificachievementDao;
import ENUM.Language;
import ENUM.Type;
import POJO.SaAttachment;
import POJO.Scientificachievement;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public ScientificachievementDaoImpl(){
        baseDao=new BaseDaoImpl();
    }


    public int pesist(Scientificachievement scientificachievement) {
        try {
            Scientificachievement po= (Scientificachievement) baseDao.persist(scientificachievement);
            return po.getId();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public void delete(int id) {
        baseDao.delete(getById(id));
    }

    public void update(Scientificachievement scientificachievement) {
        baseDao.update(scientificachievement);
    }

    public List<Scientificachievement> findAll() {
        try {
            return (List<Scientificachievement>) baseDao.findAll("Scientificachievement");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Scientificachievement> find(Type type, Language language) {
        try {
            String[] properties={TYPE,LANGUAGE};
            Object[] values={type,language};
            return (List<Scientificachievement>) baseDao.findByProperties("Scientificachievement",properties,values);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Scientificachievement getById(int id) {
        try {
            return (Scientificachievement) baseDao.findById(id,Scientificachievement.class);
        }catch ( Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Scientificachievement> getBySaTitle(String title) {
        try {
            String finalString="%";
            for (int i=0;i<title.length();i++){
                finalString+=title.charAt(i);
                finalString+="%";
            }
            String hql="from Scientificachievement s where s.title like '"+finalString+"'";
            return (List<Scientificachievement>) baseDao.findByHql(hql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Set<SaAttachment> getSaAttachment(int id) {
        Session session= DBconnection.getSession();
        Set<SaAttachment> result=new HashSet<SaAttachment>();
        try {
            Scientificachievement scientificachievement=session.get(Scientificachievement.class,id);
            result.addAll(scientificachievement.getSaAttachments());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBconnection.closeSession(session);
        }
        return result;
    }
}
