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
        SaAttachment po= (SaAttachment) baseDao.persist(saAttachment);
        return po.getId();
    }

    public void delete(int id) {
        SaAttachment po=new SaAttachment();
        po.setId(id);
        baseDao.delete(po);
    }

    public void update(SaAttachment saAttachment) {
        baseDao.update(saAttachment);
    }

    public List<SaAttachment> findAll() {
        return (List<SaAttachment>) baseDao.findAll("SaAttachment");
    }

    public SaAttachment getById(int id) {
        return (SaAttachment) baseDao.findById(id,SaAttachment.class);
    }
}
