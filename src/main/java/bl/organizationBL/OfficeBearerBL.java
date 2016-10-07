package bl.organizationBL;

import Dao.PersonDao;
import DaoImpl.PersonDaoImpl;
import ENUM.Language;
import ENUM.Type;
import ENUM.UniversalState;
import POJO.Person;
import blservice.organizationBLService.OfficeBearerBLService;
import vo.OrganizationVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/5.
 */
public class OfficeBearerBL implements OfficeBearerBLService{
    public int getID() {
        PersonDao personDao=new PersonDaoImpl();
        Person person=new Person();
        return personDao.pesist(person);
    }

    public String addItem(OrganizationVO organizationVO) {
        return null;
    }

    public UniversalState deleteItem(int id) {
        PersonDao personDao=new PersonDaoImpl();
        personDao.delete(id);
        return UniversalState.SUCCEED;
    }

    public UniversalState updateItem(OrganizationVO organizationVO) {
        PersonDao personDao=new PersonDaoImpl();
        Person person=personDao.getById(organizationVO.getId());
        person.setName(organizationVO.getName());
        person.setDescriptionLocation(organizationVO.getDescriptionLocation());
        person.setImageLocation(organizationVO.getImageLocation());
        person.setLanguage(Language.valueOf(organizationVO.getLanguage()));
        person.setType(Type.OfficeBearer);
        personDao.pesist(person);
        return UniversalState.SUCCEED;
    }

    public UniversalState sort(ArrayList<Integer> idList) {
        return null;
    }

    public OrganizationVO getItem(int id) {
        PersonDao personDao=new PersonDaoImpl();
        Person person=personDao.getById(id);
        OrganizationVO organizationVO=new OrganizationVO();
        organizationVO.setId(id);
        organizationVO.setLanguage(person.getLanguage().toString());
        organizationVO.setName(person.getName());
        organizationVO.setDescriptionLocation(person.getDescriptionLocation());
        organizationVO.setImageLocation(person.getImageLocation());
        organizationVO.setSequenceNumber(person.getSequence());
        return organizationVO;
    }

    public ArrayList<OrganizationVO> getAllItem(String language) {
        ArrayList<OrganizationVO> result=new ArrayList<OrganizationVO>();
        PersonDao personDao=new PersonDaoImpl();
//        List<Person> persons=personDao.

//        OrganizationVO organizationVO=new OrganizationVO();
//        organizationVO.setId(0);
//        organizationVO.setName("zhangsan");
//        organizationVO.setDescriptionLocation("/test/a.html");
//        organizationVO.setImageLocation("/test/test.jpg");
//        organizationVO.setSequenceNumber(0);
//        result.add(organizationVO);
//        OrganizationVO organizationVO2=new OrganizationVO();
//        organizationVO2.setId(1);
//        organizationVO2.setName("zhangsan");
//        organizationVO2.setDescriptionLocation("/test/a.html");
//        organizationVO2.setImageLocation("/test/test.jpg");
//        organizationVO2.setSequenceNumber(1);
//        result.add(organizationVO2);
        return result;
    }
}
