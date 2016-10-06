package bl.academicCommunicateBL;

import Dao.EssayDao;
import DaoImpl.EssayDaoImpl;
import ENUM.Language;
import ENUM.Type;
import ENUM.UniversalState;
import POJO.Essay;
import blservice.academicCommunicateBLService.CommunicateBLService;
import vo.AcademicVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lvdechao on 2016/10/6.
 */
public class CommunicateBL implements CommunicateBLService{
    public int getID() {
        EssayDao essayDao=new EssayDaoImpl();
        Essay essay=new Essay();
        return essayDao.pesist(essay);
    }

    public String addItem(AcademicVO academicVO) {
        return null;
    }

    public UniversalState deleteItem(int id) {
        EssayDao essayDao=new EssayDaoImpl();
        essayDao.delete(id);
        return UniversalState.SUCCEED;
    }

    public UniversalState updateItem(AcademicVO academicVO) {
        EssayDao essayDao=new EssayDaoImpl();
        Essay essay=new Essay();
        essay.setId(academicVO.getId());
        essay.setTitle(academicVO.getTitle());
        essay.setTime(new Date());
        essay.setAuthor(academicVO.getAuthor());
        essay.setLocation(academicVO.getLocation());
        essay.setLanguage(Language.valueOf(academicVO.getLanguage()));
//        essay.set
        essay.setType(Type.Communicate);
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
