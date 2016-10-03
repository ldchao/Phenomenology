package blservice.organizationBLService;

import ENUM.UniversalState;
import vo.OrganizationVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface ScholarBLService {

    //增加一条访问学者记录
    public String addItem(OrganizationVO organizationVO);

    //删除一条访问学者记录
    public UniversalState deleteItem(int id);

    //更新一条访问学者记录
    public UniversalState updateItem(OrganizationVO organizationVO);

    //将访问学者进行排序【ArrayList里面id的顺序即为最终顺序】
    public UniversalState sort(ArrayList<String> idList);

    //按排序获得所有访问学者的名单
    public ArrayList<OrganizationVO> getAllItem(String language);


}
