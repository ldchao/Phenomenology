package bl.academicCommunicateBL;

import Dao.EssayDao;
import DaoImpl.EssayDaoImpl;
import ENUM.Language;
import ENUM.Type;
import ENUM.UniversalState;
import POJO.Essay;
import bl.helper.TagManager;
import blservice.academicCommunicateBLService.CommunicateBLService;
import vo.AcademicVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Essay essay=essayDao.getById(academicVO.getId());
        essay.setTitle(academicVO.getTitle());
        essay.setTime(new Date());
        essay.setAuthor(academicVO.getAuthor());
        essay.setLocation(academicVO.getLocation());
        essay.setLanguage(Language.valueOf(academicVO.getLanguage()));
        essay.setType(Type.Communicate);
        essayDao.update(essay);
        TagManager.updateEssayTags(academicVO.getId(),academicVO.getTags());
        return UniversalState.SUCCEED;
    }

    public AcademicVO getItem(int id) {

        EssayDao essayDao=new EssayDaoImpl();
        Essay essay=essayDao.getById(id);
        int pageView=essay.getPageView()+1;
        essay.setPageView(pageView);
        essayDao.update(essay);

        AcademicVO academicVO=new AcademicVO();
        academicVO.update(essay);
        academicVO.setTags(TagManager.getEssayTags(essay.getId()));
        return academicVO;
    }

    public ArrayList<AcademicVO> getAllItems(String language) {

        ArrayList<AcademicVO> result=new ArrayList<AcademicVO>();
        EssayDao essayDao=new EssayDaoImpl();
        List<Essay> essays=essayDao.find(Type.Communicate,Language.valueOf(language));
        for (Essay essay:essays) {
            AcademicVO academicVO=new AcademicVO();
            academicVO.update(essay);
            // TODO: 2017/5/14  
            result.add(academicVO);
        }

        return result;
    }
}
