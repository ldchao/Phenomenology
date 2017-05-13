package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.SaTagDao;
import POJO.Essay;
import POJO.SaTag;
import POJO.Scientificachievement;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mm on 2017/5/14.
 */
public class SaTagImpl implements SaTagDao {
    BaseDao baseDao=new BaseDaoImpl();

    public List<SaTag> getSaTagsByScientificAchievementId(int scientificAchievementId) {
        List<SaTag> list=new ArrayList<SaTag>();
        Session session= DBconnection.getSession();
        try {
            Scientificachievement scientificachievement= null;
            String hql="from Scientificachievement s where s.id="+scientificAchievementId;
            scientificachievement= (Scientificachievement) session.createQuery(hql).uniqueResult();
            list.addAll(scientificachievement.getSaTags());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    public void addSaTag_Views(String tagName) {
        Session session= DBconnection.getSession();
        try {
            String hql="from SaTag s where s.tagName='"+tagName+"'";
            SaTag saTag= (SaTag) session.createQuery(hql).uniqueResult();
            saTag.setViews(saTag.getViews()+1);
            session.update(saTag);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<SaTag> getSaTagsOfTop10() {
        String hql="from SaTag s order by s.views desc";
        List<SaTag> list=new ArrayList<SaTag>();
        Session session= DBconnection.getSession();
        try {
            Query query=session.createQuery(hql);
            query.setFirstResult(0);
            query.setMaxResults(10);
            list=query.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    public void addRelations(int scientificAchievementId, String tagName) {
        Session session= DBconnection.getSession();
        try {
            String hql="from SaTag s where s.tagName='"+tagName+"'";
            SaTag saTag= (SaTag) session.createQuery(hql).uniqueResult();
            Scientificachievement scientificachievement= (Scientificachievement) baseDao.findById(scientificAchievementId,Scientificachievement.class);
            saTag.getScientificachievements().add(scientificachievement);
            session.update(saTag);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteByScientificAchievementIdAndTagName(int scientificAchievementId, String tagName) {
        Session session= DBconnection.getSession();
        try {
            String hql="from SaTag s where s.tagName='"+tagName+"'";
            SaTag saTag= (SaTag) session.createQuery(hql).uniqueResult();
            Set<Scientificachievement> scientificachievementSet=saTag.getScientificachievements();
            for (Scientificachievement s:scientificachievementSet){
                if (s.getId()==scientificAchievementId){
                    scientificachievementSet.remove(s);
                    break;
                }
            }
            session.update(saTag);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
