package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.ScientificachievementDao;
import ENUM.Language;
import ENUM.Type;
import POJO.SaAttachment;
import POJO.SaTag;
import POJO.Scientificachievement;
import org.hibernate.Session;
import org.springframework.web.context.request.SessionScope;
import sun.security.pkcs11.Secmod;

import java.util.ArrayList;
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
            String hql="from Scientificachievement s order by s.time desc";
            return (List<Scientificachievement>) baseDao.findByHql(hql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Scientificachievement> find(Type type, Language language) {
        try {
            String hql="from Scientificachievement s where s.type='"+type+"' and s.language='"+language+"'  order by s.time desc";
            return (List<Scientificachievement>) baseDao.findByHql(hql);
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

    public List<Scientificachievement> getScientificAchievementBySaTag(String tagName) {
        List<Scientificachievement> list=new ArrayList<Scientificachievement>();
        Session session=DBconnection.getSession();
        try{
            String hql="from SaTag s where s.tagName='"+tagName+"'";
            List<SaTag> saTags=session.createQuery(hql).list();
            if (saTags.size()!=0){
                list.addAll(saTags.get(0).getScientificachievements());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}
