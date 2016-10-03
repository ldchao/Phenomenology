package blservice.academicSourceBLService;

import ENUM.UniversalState;
import vo.AcademicVO;
import vo.AccessoryVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface CircleNewsBLService {

    //增加一条学界动态记录
    public String addItem(AcademicVO academicVO);

    //增加一条学界动态附件添加记录
    public String addAccessory(AccessoryVO accessoryVO);

    //删除一条学界动态的记录
    public UniversalState deleteItem(int id);

    //更新一条学界动态的记录
    public UniversalState updateItem(AcademicVO academicVO);

    //获取全部学界动态的记录
    public ArrayList<AcademicVO> getAllItems(String language);



}
