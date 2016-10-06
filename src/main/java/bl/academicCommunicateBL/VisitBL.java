package bl.academicCommunicateBL;

import ENUM.UniversalState;
import blservice.academicCommunicateBLService.VisitBLService;
import vo.AcademicVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/6.
 */
public class VisitBL implements VisitBLService {

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
        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(0);
        academicVO.setAuthor("zhangsan");
        academicVO.setLocation("/test/a.html");
        academicVO.setTitle("ceshiceshi");
        academicVO.setPageView(0);
        academicVO.setTime("2010-1-1");
        return academicVO;
    }

    public ArrayList<AcademicVO> getAllItems(String language) {
        ArrayList<AcademicVO> result=new ArrayList<AcademicVO>();
        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(0);
        academicVO.setAuthor("zhangsan");
        academicVO.setLocation("/test/a.html");
        academicVO.setTitle("ceshiceshi");
        academicVO.setPageView(0);
        academicVO.setTime("2010-1-1");
        result.add(academicVO);
        AcademicVO academicVO2=new AcademicVO();
        academicVO2.setId(1);
        academicVO2.setAuthor("zhangsan");
        academicVO2.setLocation("/test/a.html");
        academicVO2.setTitle("ceshiceshi");
        academicVO2.setPageView(0);
        academicVO2.setTime("2010-1-1");
        result.add(academicVO2);
        return result;
    }
}
