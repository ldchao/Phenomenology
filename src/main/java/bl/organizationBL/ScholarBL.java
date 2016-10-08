package bl.organizationBL;

import Dao.PersonDao;
import DaoImpl.PersonDaoImpl;
import ENUM.Language;
import ENUM.Type;
import ENUM.UniversalState;
import POJO.Person;
import blservice.organizationBLService.ScholarBLService;
import vo.OrganizationVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/5.
 */
public class ScholarBL implements ScholarBLService{
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
        person.setType(Type.Scholar);
        personDao.pesist(person);
        return UniversalState.SUCCEED;
    }


    public UniversalState sort(ArrayList<Integer> idList) {
        PersonDao personDao=new PersonDaoImpl();
        personDao.rank(idList);
        return UniversalState.SUCCEED;
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
        List<Person> persons=personDao.getByTypeAndLanguage(Type.Scholar,Language.valueOf(language));

        for (Person person:persons) {
            OrganizationVO organizationVO=new OrganizationVO();
            organizationVO.setId(person.getId());
            organizationVO.setName(person.getName());
            organizationVO.setDescriptionLocation(person.getDescriptionLocation());
            organizationVO.setImageLocation(person.getImageLocation());
            result.add(organizationVO);
        }
        return result;
    }

}
