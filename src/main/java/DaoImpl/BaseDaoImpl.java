package DaoImpl;

import Dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mm on 2016/10/6.
 */
public class BaseDaoImpl implements BaseDao {
//    @Autowired
    SessionFactory sessionFactory;

    public Object persist(Object bean) {
        Session session=sessionFactory.getCurrentSession();
        Object result=null;
        try {
            session.save(bean);
            Transaction transaction=session.beginTransaction();
            transaction.commit();
            result=bean;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void delete(Object bean) {

    }

    public void update(Object bean) {

    }

    public Object findById(Object bean) {
        return null;
    }
}
