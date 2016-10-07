package bl.accessoryBL;

import Dao.EssayAttachmentDao;
import Dao.EssayDao;
import Dao.SaAttachmentDao;
import Dao.ScientificachievementDao;
import DaoImpl.EssayAttachmentDaoImpl;
import DaoImpl.EssayDaoImpl;
import DaoImpl.SaAttachmentDaoImpl;
import DaoImpl.ScientificachievementDaoImpl;
import ENUM.UniversalState;
import POJO.Essay;
import POJO.EssayAttachment;
import POJO.SaAttachment;
import POJO.Scientificachievement;
import blservice.accessoryBLService.AccessoryBLService;
import vo.AccessoryVO;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by lvdechao on 2016/10/5.
 */
public class AccessoryBL implements AccessoryBLService{


    public int addEssayAccessory(AccessoryVO accessoryVO) {
        EssayAttachment essayAttachment=new EssayAttachment();
        EssayAttachmentDao essayAttachmentDao=new EssayAttachmentDaoImpl();
        essayAttachment.setTitle(accessoryVO.getName());
        Essay essay=new Essay();
        essay.setId(accessoryVO.getTextId());
        essayAttachment.setEssay(essay);
        essayAttachment.setLocation(accessoryVO.getLocation());
        return essayAttachmentDao.pesist(essayAttachment);
    }
    public AccessoryVO getEssayAccessory(int id) {
        EssayDao essayDao=new EssayDaoImpl();
        Set<EssayAttachment> essayAttachments=essayDao.getByEssayAttachment(id);
        for (EssayAttachment essayAttachment:essayAttachments){
            AccessoryVO accessory=new AccessoryVO();
            accessory.setAccessoryId(essayAttachment.getId());
            accessory.setName(essayAttachment.getTitle());
            accessory.setTextId(id);
            accessory.setLocation(essayAttachment.getLocation());
            return accessory;
        }
        return null;
    }

    public UniversalState deleteEssayAccessory(int accessoryID) {
        EssayAttachmentDao essayAttachmentDao=new EssayAttachmentDaoImpl();
        essayAttachmentDao.delete(accessoryID);
        return UniversalState.SUCCEED;
    }

    public int addSaAccessory(AccessoryVO accessoryVO) {
        SaAttachmentDao saAttachmentDao=new SaAttachmentDaoImpl();
        SaAttachment sa=new SaAttachment();
        sa.setTitle(accessoryVO.getName());
        sa.setLocation(accessoryVO.getLocation());
        Scientificachievement scientificachievement=new Scientificachievement();
        scientificachievement.setId(accessoryVO.getTextId());
        sa.setScientificachievement(scientificachievement);
        return saAttachmentDao.pesist(sa);
    }

    public AccessoryVO getSaAccessory(int id) {
        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        Set<SaAttachment> saAttachments=scientificachievementDao.getSaAttachment(id);
        for (SaAttachment sa:saAttachments) {
            AccessoryVO accessory=new AccessoryVO();
            accessory.setAccessoryId(sa.getId());
            accessory.setName(sa.getTitle());
            accessory.setTextId(id);
            accessory.setLocation(sa.getLocation());
            return accessory;
        }
        return null;
    }

    public UniversalState deleteSaAccessory(int accessoryID) {
        SaAttachmentDao saAttachmentDao=new SaAttachmentDaoImpl();
        saAttachmentDao.delete(accessoryID);
        return UniversalState.SUCCEED;
    }
}
