package blservice.organizationBLService;

import ENUM.UniversalState;
import vo.OrganizationVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface OfficeBearerBLService {

    //得到一个新的存储id
    public int getID();

    //增加一条在职人员记录
    public String addItem(OrganizationVO organizationVO);

    //删除一条在职人员记录
    public UniversalState deleteItem(int id);

    //更新一条在职人员记录
    public UniversalState updateItem(OrganizationVO organizationVO);

    //将在职人员进行排序【ArrayList里面id的顺序即为最终顺序】
    public UniversalState sort(ArrayList<Integer> idList);

    //得到某位在职人员的详细信息
    public OrganizationVO getItem(int id);

    //按排序获得所有在职人员的名单
    public ArrayList<OrganizationVO> getAllItem(String language);


}
