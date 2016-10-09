package DaoImpl;

import Connection.DBconnection;
import Dao.BaseDao;
import Dao.HomepageDao;
import Dao.HomepageEssayDao;
import ENUM.Language;
import ENUM.Type;
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
    public static final String HOMEPAGE_ID="homepage.id";
    public HomepageEssayDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public int pesist(HomepageEssay homepageEssay) {
        try {
            HomepageEssay po= (HomepageEssay) baseDao.persist(homepageEssay);
            return po.getId();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
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
        try {
            String hql="from HomepageEssay h where h.homepage.id="+i;
            return (List<HomepageEssay>) baseDao.findByHql(hql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public HomepageEssay getById(int id) {
        try {
            return (HomepageEssay) baseDao.findById(id,HomepageEssay.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void rank(ArrayList<Integer> sequence) {
        ArrayList<HomepageEssay> arrayList=(ArrayList<HomepageEssay>)baseDao.findAll("HomepageEssay");
        baseDao.clean("HomepageEssay");
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

    public List<HomepageEssay> findTop5(int homepageId) {
        try {
            String[] properties={HOMEPAGE_ID};
            Object[] values={homepageId};
            return (List<HomepageEssay>) baseDao.findByPropertiesAndPages("HomepageEssay",properties,values,0,5);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<HomepageEssay> find(int homepageId) {
        try {
            String[] properties={HOMEPAGE_ID};
            Object[] values={homepageId};
            return (List<HomepageEssay>) baseDao.findByProperties("HomepageEssay",properties,values);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
