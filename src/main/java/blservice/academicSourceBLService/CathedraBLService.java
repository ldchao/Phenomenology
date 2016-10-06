package blservice.academicSourceBLService;

import ENUM.UniversalState;
import vo.AcademicVO;
import vo.AccessoryVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface CathedraBLService {

    //得到一个新的id
    public int getID();

    //增加一条讲座实录记录
    public String addItem(AcademicVO academicVO);

    //删除一条讲座实录的记录
    public UniversalState deleteItem(int id);

    //更新一条讲座实录的记录
    public UniversalState updateItem(AcademicVO academicVO);

    //获取一条讲座实录的记录
    public AcademicVO getItem(int id);

    //获取全部讲座实录的记录
    public ArrayList<AcademicVO> getAllItems(String language);



}
