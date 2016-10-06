package bl.academicCommunicateBL;

import ENUM.UniversalState;
import blservice.academicCommunicateBLService.CommunicateBLService;
import blservice.academicSourceBLService.CourseBLService;
import vo.AcademicVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/6.
 */
public class CommunicateBL implements CommunicateBLService{
    public int getID() {
        return 0;
    }

    public String addItem(AcademicVO academicVO) {
        return null;
    }

    public UniversalState deleteItem(int id) {
        return null;
    }

    public UniversalState updateItem(AcademicVO academicVO) {
        return null;
    }

    public AcademicVO getItem(int id) {
        return null;
    }

    public ArrayList<AcademicVO> getAllItems(String language) {
        return null;
    }
}
