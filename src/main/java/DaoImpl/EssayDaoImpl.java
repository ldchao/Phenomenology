package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.EssayDao;
import ENUM.Language;
import ENUM.Type;
import POJO.Essay;
import POJO.EssayAttachment;
import POJO.EssayTag;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
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
        String hql="from Essay e"+" order by e.time desc";
        try {
            return (List<Essay>) baseDao.findByHql(hql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Essay> findTop5(Type type, Language language) {
        String hql="from Essay e where e.type='"+type+"' and e.language='"+language+"' order by e.time desc ";
        try {
            Session session=DBconnection.getSession();
            try {
                Query query=session.createQuery(hql);
                query.setFirstResult(0);
                query.setMaxResults(5);
                List<Essay> result=query.list();
                return result;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }finally {
                session.close();
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Essay> find(Type type, Language language) {
        String hql="from Essay e where e.type='"+type+"' and e.language='"+language+"' order by e.time desc";
        try {
            return (List<Essay>) baseDao.findByHql(hql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
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
        String hql="from Essay e where e.title like '"+finalString+"' order by e.time desc";
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

    public List<Essay> getEssaysByEssayTag(String tagName) {
        List<Essay> list=new ArrayList<Essay>();
        Session session=DBconnection.getSession();
        try{
            String hql="from EssayTag e where e.tagName='"+tagName+"'";
            List<EssayTag> essays=session.createQuery(hql).list();
            if (essays.size()!=0){
                list.addAll(essays.get(0).getEssays());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}
