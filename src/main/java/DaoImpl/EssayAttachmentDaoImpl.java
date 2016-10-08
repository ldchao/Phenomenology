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
    public EssayAttachmentDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public int pesist(EssayAttachment essayAttachment) {
        EssayAttachment po=(EssayAttachment)baseDao.persist(essayAttachment);
        return po.getId();
    }

    public void delete(int id) {
        EssayAttachment essayAttachment=new EssayAttachment();
        essayAttachment.setId(id);
        baseDao.delete(essayAttachment);
    }

    public void update(EssayAttachment essayAttachment) {
        baseDao.update(essayAttachment);
    }

    public EssayAttachment getById(int id){
        return (EssayAttachment) baseDao.findById(id,EssayAttachmentDao.class);
    };

    public List<EssayAttachment> findAll() {
        return (List<EssayAttachment>)baseDao.findAll("EssayAttachment");
    }
}
