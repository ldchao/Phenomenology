package DaoImpl;

import Dao.BaseDao;
import Dao.SaAttachmentDao;
import POJO.SaAttachment;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class SaAttachmentDaoImpl implements SaAttachmentDao {
    BaseDao baseDao;

    public SaAttachmentDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public int pesist(SaAttachment saAttachment) {
        try {
            SaAttachment po= (SaAttachment) baseDao.persist(saAttachment);
            return po.getId();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public void delete(int id) {
        try {
            baseDao.delete(baseDao.findById(id,SaAttachment.class));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(SaAttachment saAttachment) {
        baseDao.update(saAttachment);
    }

    public List<SaAttachment> findAll() {
        try {
            return (List<SaAttachment>) baseDao.findAll("SaAttachment");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public SaAttachment getById(int id) {
        try {
            return (SaAttachment) baseDao.findById(id,SaAttachment.class);
        }catch (Exception e){
            return null;
        }
    }
}
