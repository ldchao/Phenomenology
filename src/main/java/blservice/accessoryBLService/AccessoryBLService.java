package blservice.accessoryBLService;

import ENUM.UniversalState;
import vo.AccessoryVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/5.
 */
public interface AccessoryBLService {

    //增加一条学术附件表记录
    public int addEssayAccessory(AccessoryVO accessoryVO);

    //删除一条学术附件表记录
    public UniversalState deleteEssayAccessory(int accessoryID);

    //根据学术id得到所有附件列表
    public ArrayList<AccessoryVO> getEssayAccessory(int id);

    //增加一条科研成果附件表记录
    public int addSaAccessory(AccessoryVO accessoryVO);

    //删除一条科研成果附件表记录
    public UniversalState deleteSaAccessory(int accessoryID);

    //根据科研成果id得到所有附件列表
    public ArrayList<AccessoryVO> getSaAccessory(int id);


}
