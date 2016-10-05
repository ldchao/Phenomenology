package blservice.accessoryBLService;

import vo.AccessoryVO;

/**
 * Created by lvdechao on 2016/10/5.
 */
public interface AccessoryBLService {

    //增加一条学术附件表记录

    public int addEssayAccessory(AccessoryVO accessoryVO);

    //增加一条科研成果附件表记录

    public int addSaAccessory(AccessoryVO accessoryVO);


}
