package bl.academicCommunicateBL;

import Dao.EssayDao;
import DaoImpl.EssayDaoImpl;
import ENUM.Language;
import ENUM.Type;
import ENUM.UniversalState;
import POJO.Essay;
import blservice.academicCommunicateBLService.VisitBLService;
import vo.AcademicVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/6.
 */
public class VisitBL implements VisitBLService {

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
        Essay essay=essayDao.getById(academicVO.getId());
        essay.setTitle(academicVO.getTitle());
        essay.setTime(new Date());
        essay.setAuthor(academicVO.getAuthor());
        essay.setLocation(academicVO.getLocation());
        essay.setLanguage(Language.valueOf(academicVO.getLanguage()));
        essay.setType(Type.Visit);
        essayDao.update(essay);
        return UniversalState.SUCCEED;
    }
    public AcademicVO getItem(int id) {
        EssayDao essayDao=new EssayDaoImpl();
        Essay essay=essayDao.getById(id);
        int pageView=essay.getPageView()+1;
        essay.setPageView(pageView);
        essayDao.update(essay);

        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(essay.getId());
        academicVO.setAuthor(essay.getAuthor());
        academicVO.setLocation(essay.getLocation());
        academicVO.setTitle(essay.getTitle());
        academicVO.setPageView(pageView);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        academicVO.setTime(sdf.format(essay.getTime()));
        return academicVO;
    }

    public ArrayList<AcademicVO> getAllItems(String language) {
        ArrayList<AcademicVO> result=new ArrayList<AcademicVO>();
        EssayDao essayDao=new EssayDaoImpl();
        List<Essay> essays=essayDao.find(Type.Visit,Language.valueOf(language));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for (Essay essay:essays) {
            AcademicVO academicVO=new AcademicVO();
            academicVO.setId(essay.getId());
            academicVO.setAuthor(essay.getAuthor());
            academicVO.setLocation(essay.getLocation());
            academicVO.setTitle(essay.getTitle());
            academicVO.setPageView(essay.getPageView());
            academicVO.setTime(sdf.format(essay.getTime()));
            result.add(academicVO);
        }

        return result;
    }
}
