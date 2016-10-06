package bl.accessoryBL;

import Dao.EssayAttachmentDao;
import DaoImpl.EssayAttachmentDaoImpl;
import ENUM.UniversalState;
import POJO.EssayAttachment;
import blservice.accessoryBLService.AccessoryBLService;
import vo.AccessoryVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/5.
 */
public class AccessoryBL implements AccessoryBLService{


    public int addEssayAccessory(AccessoryVO accessoryVO) {
        EssayAttachment essayAttachment=new EssayAttachment();
        //// TODO: 2016/10/6
        EssayAttachmentDao essayAttachmentDao=new EssayAttachmentDaoImpl();
        essayAttachmentDao.pesist(essayAttachment);
        return 0;
    }
    public ArrayList<AccessoryVO> getEssayAccessory(int id) {
        return null;
    }

    public UniversalState deleteEssayAccessory(int accessoryID) {
        return null;
    }

    public int addSaAccessory(AccessoryVO accessoryVO) {
        return 0;
    }

    public ArrayList<AccessoryVO> getSaAccessory(int id) {
        return null;
    }

    public UniversalState deleteSaAccessory(int accessoryID) {
        return null;
    }
}
