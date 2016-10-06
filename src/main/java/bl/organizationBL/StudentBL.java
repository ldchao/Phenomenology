package bl.organizationBL;

import ENUM.UniversalState;
import blservice.organizationBLService.StudentBLService;
import vo.OrganizationVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/5.
 */
public class StudentBL implements StudentBLService{
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
        return null;
    }

    public ArrayList<OrganizationVO> getAllItem(String language) {
        return null;
    }
}
