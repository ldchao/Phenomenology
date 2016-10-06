package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mm on 2016/10/6.
 */
public class BaseDaoImpl implements BaseDao {

    public Object persist(Object bean) {
        Session session= DBconnection.getSession();
        Object result=null;
        try {
            session.save(bean);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
            result=bean;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBconnection.closeSession(session);
        }
        return result;
    }

    public void delete(Object bean) {
        Session session= DBconnection.getSession();
        try {
            session.delete(bean);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(Object bean) {
        Session session=DBconnection.getSession();
        try {
            session.update(bean);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    public Object findById(int i,Class clazz) {
        Session session=DBconnection.getSession();
        Object result=null;
        try {
            result=session.get(clazz,i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }
}
