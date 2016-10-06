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

    }

    public void update(EssayAttachment essayAttachment) {

    }

    public EssayAttachment getById(int id){
        return  null;
    };

    public List<EssayAttachment> findAll() {
        return null;
    }
}
