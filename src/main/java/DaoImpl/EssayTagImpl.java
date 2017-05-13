package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.EssayTagDao;
import POJO.Essay;
import POJO.EssayTag;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by mm on 2017/5/14.
 */
public class EssayTagImpl implements EssayTagDao {
    BaseDao baseDao=new BaseDaoImpl();
    public List<EssayTag> getEssayTagsByEssayId(int essayId) {
        List<EssayTag> list=new ArrayList<EssayTag>();
        Session session= DBconnection.getSession();
        try {
            Essay essay= null;
            String hql="from Essay e where e.id="+essayId;
            essay= (Essay) session.createQuery(hql).uniqueResult();
            list.addAll(essay.getEssayTags());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    public void AddEssayTag_Views(String tagName) {
        Session session= DBconnection.getSession();
        try {
            String hql="from EssayTag e where e.tagName='"+tagName+"'";
            EssayTag essayTag= (EssayTag) session.createQuery(hql).uniqueResult();
            essayTag.setViews(essayTag.getViews()+1);
            session.update(essayTag);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<EssayTag> getEssayTagsOfTop10() {
        String hql="from EssayTag e order by e.views desc";
        List<EssayTag> list=new ArrayList<EssayTag>();
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

    public void addRelations(int essayId, String tagName) {
        Session session= DBconnection.getSession();
        try {
            String hql="from EssayTag e where e.tagName='"+tagName+"'";
            EssayTag essayTag= (EssayTag) session.createQuery(hql).uniqueResult();
            Essay essay= (Essay) baseDao.findById(essayId,Essay.class);
            essayTag.getEssays().add(essay);
            session.update(essayTag);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteByEssayIdAndTagName(int essayId, String tagName) {
        Session session= DBconnection.getSession();
        try {
            String hql="from EssayTag e where e.tagName='"+tagName+"'";
            EssayTag essayTag= (EssayTag) session.createQuery(hql).uniqueResult();
            Set<Essay> essays=essayTag.getEssays();
            for (Essay e:essays){
                if (e.getId()==essayId){
                    essays.remove(e);
                    break;
                }
            }
            session.update(essayTag);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
