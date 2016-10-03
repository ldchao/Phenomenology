package blservice.organizationBLService;

import ENUM.UniversalState;
import vo.OrganizationVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface StudentBLService {

    //增加一条本所学生记录
    public String addItem(OrganizationVO organizationVO);

    //删除一条本所学生记录
    public UniversalState deleteItem(String id);

    //更新一条本所学生记录
    public UniversalState updateItem(OrganizationVO organizationVO);

    //将本所学生进行排序【ArrayList里面id的顺序即为最终顺序】
    public UniversalState sort(ArrayList<String> idList);

    //按排序获得所有本所学生的名单
    public ArrayList<OrganizationVO> getAllItem(String language);


}
