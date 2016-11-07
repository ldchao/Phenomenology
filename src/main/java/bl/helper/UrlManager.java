package bl.helper;

import Dao.EssayDao;
import Dao.PersonDao;
import Dao.ScientificachievementDao;
import DaoImpl.EssayDaoImpl;
import DaoImpl.PersonDaoImpl;
import DaoImpl.ScientificachievementDaoImpl;
import ENUM.Type;
import POJO.Essay;
import POJO.Person;
import POJO.Scientificachievement;
import vo.FromURLVO;

/**
 * Created by lvdechao on 2016/10/8.
 */
public class UrlManager {


    public static void main(String[] args) {
        String url=UrlManager.getAcademicUrl(11);
        System.out.println(url);
    }

    //解析url返回对应文章的标题和内容
    public static FromURLVO ReadUrl(String url) {

        String[] items=url.split("/");
        int length=items.length;
        FromURLVO fromURLVO=new FromURLVO();
        if(length<=5){
            fromURLVO.setTitle("非本站链接");
            fromURLVO.setHtmlLocation("");
        }else{
            String kind=items[length-3];
            String ids[]=items[length-1].split("=");
            int id=Integer.parseInt(ids[1]);

            if(kind.equals("organization")){
                PersonDao personDao=new PersonDaoImpl();
                Person person=personDao.getById(id);
                fromURLVO.setTitle(person.getName());
                fromURLVO.setHtmlLocation(person.getDescriptionLocation());
            }else if(kind.equals("achievement")){
                ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
                Scientificachievement scientificachievement=scientificachievementDao.getById(id);
                fromURLVO.setTitle(scientificachievement.getTitle());
                fromURLVO.setHtmlLocation(scientificachievement.getDescriptionLocation());
            }else if(kind.equals("academic")||kind.equals("academicCommunicate")){
                EssayDao essayDao=new EssayDaoImpl();
                Essay essay=essayDao.getById(id);
                fromURLVO.setTitle(essay.getTitle());
                fromURLVO.setHtmlLocation(essay.getLocation());
            }else{
                fromURLVO.setTitle("非本站链接");
                fromURLVO.setHtmlLocation("");
            }
        }
        return fromURLVO;
    }


    //根据文章对象返回对应url
    public static String getAcademicUrl(int id) {
        String url="/";
        EssayDao essayDao=new EssayDaoImpl();
        Essay essay=essayDao.getById(id);
        if(essay.getType()==Type.CircleNews){
            url+="academic/circleNews/detail?id="+id;
        }else{
            if(essay.getType()== Type.Cathedra||essay.getType()==Type.Course){
                url+="academic/";
            }else{
                url+="academicCommunicate/";
            }
            url+=essay.getType().toString().toLowerCase()+"/detail?id="+id;
        }

        return url;
    }


    //根据人员对象返回对应url
    public static String getOrganizationUrl(int id) {
        String url="/organization/";
        PersonDao personDao=new PersonDaoImpl();
        Person person=personDao.getById(id);
        if(person.getType()==Type.OfficeBearer){
            url+="officeBearer/detail?id="+id;
        }else
           url+=person.getType().toString().toLowerCase()+"/detail?id="+id;
        return url;
    }


    //根据科研成果对象返回对应url
    public static String getAchievementUrl(int id) {
        String url="/achievement/";
        ScientificachievementDao scientificachievementDao=new ScientificachievementDaoImpl();
        Scientificachievement scientificachievement=scientificachievementDao.getById(id);
        url+=scientificachievement.getType().toString().toLowerCase()+"/detail?id="+id;
        return url;
    }


}
