package blservice.academicCommunicateBLService;

import ENUM.UniversalState;
import vo.AcademicVO;
import vo.AccessoryVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface LectureBLService {

    //增加一条学术讲座记录
    public String addItem(AcademicVO academicVO);

    //增加一条学术讲座附件添加记录
    public String addAccessory(AccessoryVO accessoryVO);

    //删除一条学术讲座的记录
    public UniversalState deleteItem(String id);

    //更新一条学术讲座的记录
    public UniversalState updateItem(AcademicVO academicVO);

    //获取全部学术讲座的记录
    public ArrayList<AcademicVO> getAllItems(String language);



}
