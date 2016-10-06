package bl.organizationBL;

import ENUM.UniversalState;
import blservice.organizationBLService.ScholarBLService;
import vo.OrganizationVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/5.
 */
public class ScholarBL implements ScholarBLService{
    public int getID() {
        return 0;
    }

    public String addItem(OrganizationVO organizationVO) {
        return null;
    }

    public UniversalState deleteItem(int id) {
        return null;
    }

    public UniversalState updateItem(OrganizationVO organizationVO) {
        return null;
    }

    public UniversalState sort(ArrayList<Integer> idList) {
        return null;
    }

    public OrganizationVO getItem(int id) {
        OrganizationVO organizationVO=new OrganizationVO();
        organizationVO.setId(0);
        organizationVO.setName("zhangsan");
        organizationVO.setDescriptionLocation("/test/a.html");
        organizationVO.setImageLocation("/test/test.jpg");
        organizationVO.setSequenceNumber(0);

        return organizationVO;
    }

    public ArrayList<OrganizationVO> getAllItem(String language) {
        ArrayList<OrganizationVO> result=new ArrayList<OrganizationVO>();
        OrganizationVO organizationVO=new OrganizationVO();
        organizationVO.setId(0);
        organizationVO.setName("zhangsan");
        organizationVO.setDescriptionLocation("/test/a.html");
        organizationVO.setImageLocation("/test/test.jpg");
        organizationVO.setSequenceNumber(0);
        result.add(organizationVO);
        OrganizationVO organizationVO2=new OrganizationVO();
        organizationVO2.setId(1);
        organizationVO2.setName("zhangsan");
        organizationVO2.setDescriptionLocation("/test/a.html");
        organizationVO2.setImageLocation("/test/test.jpg");
        organizationVO2.setSequenceNumber(1);
        result.add(organizationVO2);
        return result;
    }

}
