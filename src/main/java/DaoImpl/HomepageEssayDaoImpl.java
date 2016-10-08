package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.HomepageDao;
import Dao.HomepageEssayDao;
import POJO.Essay;
import POJO.Homepage;
import POJO.HomepageEssay;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class HomepageEssayDaoImpl implements HomepageEssayDao {
    BaseDao baseDao;
    public static final String LANGUAGE="language";
    public static final String TYPE="type";

    public HomepageEssayDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public int pesist(HomepageEssay homepageEssay) {
        HomepageEssay po= (HomepageEssay) baseDao.persist(homepageEssay);
        return po.getId();
    }

    public void delete(int id) {
        HomepageEssay homepageEssay=new HomepageEssay();
        homepageEssay.setId(id);
        baseDao.delete(homepageEssay);
    }

    public void update(HomepageEssay homepageEssay) {
        baseDao.update(homepageEssay);
    }

    public List<HomepageEssay> findAll(int i) {
        String hql="from HomepageEssay h where h.homepage.id="+i;
        return (List<HomepageEssay>) baseDao.findByHql(hql);
    }


    public HomepageEssay getById(int id) {
        return (HomepageEssay) baseDao.findById(id,HomepageEssay.class);
    }

    public void rank(ArrayList<Integer> sequence) {
        baseDao.clean("HomepageEssay");
        ArrayList<HomepageEssay> arrayList=(ArrayList<HomepageEssay>)baseDao.findAll("HomepageEssay");
        for (int i=0;i<sequence.size();i++){
            for (int j=0;j<arrayList.size();j++){
                if (arrayList.get(j).getId()==sequence.get(i)){
                    arrayList.get(j).setSequenceNumber(i+1);
                    break;
                }
            }
        }
        Session session= DBconnection.getSession();
        try {
            for (HomepageEssay homepageEssay:arrayList){
                session.save(homepageEssay);
            }
            Transaction transaction=session.beginTransaction();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Essay> findTop5(String type, String language) {
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Essay>) baseDao.findByPropertiesAndPages("Essay",properties,values,0,5);
    }

    public List<Essay> find(String type, String language) {
        String[] properties={TYPE,LANGUAGE};
        Object[] values={type,language};
        return (List<Essay>) baseDao.findByProperties("Essay",properties,values);
    }
}
