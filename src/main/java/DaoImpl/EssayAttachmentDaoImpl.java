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
        try {
            EssayAttachment po=(EssayAttachment)baseDao.persist(essayAttachment);
            return po.getId();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }

    public void delete(int id) {

        baseDao.delete(getById(id));
    }

    public void update(EssayAttachment essayAttachment) {
        baseDao.update(essayAttachment);
    }

    public EssayAttachment getById(int id){
        EssayAttachment essayAttachment=null;
        try {
            essayAttachment= (EssayAttachment) baseDao.findById(id,EssayAttachment.class);
        }catch ( Exception e){
            e.printStackTrace();
        }
        return essayAttachment;
    };

    public List<EssayAttachment> findAll() {
        try {
            return (List<EssayAttachment>)baseDao.findAll("EssayAttachment");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
