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
    public int pesist(SaAttachment saAttachment) {
        baseDao=new BaseDaoImpl();
        SaAttachment po= (SaAttachment) baseDao.persist(saAttachment);
        return po.getId();
    }

    public void delete(int id) {
        baseDao=new BaseDaoImpl();
        SaAttachment po=new SaAttachment();
        po.setId(id);
        baseDao.delete(po);
    }

    public void update(SaAttachment saAttachment) {
        baseDao=new BaseDaoImpl();
        baseDao.update(saAttachment);
    }

    public List<SaAttachment> findAll() {
        baseDao=new BaseDaoImpl();
        return (List<SaAttachment>) baseDao.findAll("SaAttachment");
    }

    public SaAttachment getById(int id) {
        baseDao=new BaseDaoImpl();
        return (SaAttachment) baseDao.findById(id,SaAttachment.class);
    }
}
