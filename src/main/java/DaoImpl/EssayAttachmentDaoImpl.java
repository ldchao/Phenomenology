package DaoImpl;

import Dao.BaseDao;
import Dao.EssayAttachmentDao;
import POJO.EssayAttachment;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class EssayAttachmentDaoImpl implements EssayAttachmentDao {
    BaseDao baseDao;
    public int pesist(EssayAttachment essayAttachment) {
        baseDao=new BaseDaoImpl();
        EssayAttachment po=(EssayAttachment)baseDao.persist(essayAttachment);
        return po.getId();
    }

    public void delete(int id) {
        baseDao=new BaseDaoImpl();
        EssayAttachment essayAttachment=new EssayAttachment();
        essayAttachment.setId(id);
        baseDao.delete(essayAttachment);
    }

    public void update(EssayAttachment essayAttachment) {
        baseDao=new BaseDaoImpl();
        baseDao.update(essayAttachment);
    }

    public EssayAttachment getById(int id){
        baseDao=new BaseDaoImpl();
        return (EssayAttachment) baseDao.findById(id,EssayAttachmentDao.class);
    };

    public List<EssayAttachment> findAll() {
        baseDao=new BaseDaoImpl();
        return (List<EssayAttachment>)baseDao.findAll("EssayAttachment");
    }
}
