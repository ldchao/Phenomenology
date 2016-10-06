package controller;

import ENUM.UniversalState;
import bl.academicCommunicateBL.CommunicateBL;
import bl.academicCommunicateBL.LectureBL;
import bl.academicCommunicateBL.VisitBL;
import bl.academicSourceBL.CathedraBL;
import bl.academicSourceBL.CircleNewsBL;
import bl.academicSourceBL.CourseBL;
import blservice.academicCommunicateBLService.CommunicateBLService;
import blservice.academicCommunicateBLService.LectureBLService;
import blservice.academicCommunicateBLService.VisitBLService;
import blservice.academicSourceBLService.CathedraBLService;
import blservice.academicSourceBLService.CircleNewsBLService;
import blservice.academicSourceBLService.CourseBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.AcademicVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/3.
 */

@Controller
@RequestMapping(value = "/academic")
public class AcademicController {


    @RequestMapping(value = "/cathedra/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getCathedraID() {
        CathedraBLService cathedraBLService=new CathedraBL();
        return cathedraBLService.getID();
    }

    @RequestMapping(value = "/cathedra/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateLecture(int id,String title,String author,
                                String location,String language) {

        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(id);
        academicVO.setTitle(title);
        academicVO.setAuthor(author);
        academicVO.setLocation(location);
        academicVO.setLanguage(language);
        CathedraBLService cathedraBLService=new CathedraBL();
        UniversalState universalState=cathedraBLService.updateItem(academicVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/cathedra/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteLecture(int id) {
        CathedraBLService cathedraBLService=new CathedraBL();
        UniversalState universalState=cathedraBLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/cathedra/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneCathedra(int id) {
        CathedraBLService cathedraBLService=new CathedraBL();
        return cathedraBLService.getItem(id);
    }

    @RequestMapping(value = "/cathedra/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<AcademicVO> getLecture(String language) {
        CathedraBLService cathedraBLService=new CathedraBL();
        return cathedraBLService.getAllItems(language);
    }

    @RequestMapping(value = "/circleNews/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getCircleNewsID() {
        CircleNewsBLService circleNewsBLService=new CircleNewsBL();
        return circleNewsBLService.getID();
    }

    @RequestMapping(value = "/circleNews/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateCommunicate(int id,String title,String author,
                                    String location,String language) {

        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(id);
        academicVO.setTitle(title);
        academicVO.setAuthor(author);
        academicVO.setLocation(location);
        academicVO.setLanguage(language);
        CircleNewsBLService circleNewsBLService=new CircleNewsBL();
        UniversalState universalState=circleNewsBLService.updateItem(academicVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/circleNews/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCommunicate(int id) {
        CircleNewsBLService circleNewsBLService=new CircleNewsBL();
        UniversalState universalState=circleNewsBLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/circleNews/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneCircleNews(int id) {
        CircleNewsBLService circleNewsBLService=new CircleNewsBL();
        return circleNewsBLService.getItem(id);
    }

    @RequestMapping(value = "/circleNews/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<AcademicVO> getCommunicate(String language) {
        CircleNewsBLService circleNewsBLService=new CircleNewsBL();
        return circleNewsBLService.getAllItems(language);
    }

    @RequestMapping(value = "/course/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getCourseID() {
        CourseBLService courseLService=new CourseBL();
        return courseLService.getID();
    }

    @RequestMapping(value = "/course/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateVisit(int id,String title,String author,
                              String location,String language) {

        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(id);
        academicVO.setTitle(title);
        academicVO.setAuthor(author);
        academicVO.setLocation(location);
        academicVO.setLanguage(language);
        CourseBLService courseLService=new CourseBL();
        UniversalState universalState=courseLService.updateItem(academicVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/course/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteVisit(int id) {
        CourseBLService courseLService=new CourseBL();
        UniversalState universalState=courseLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/course/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneCourse(int id) {
        CourseBLService courseLService=new CourseBL();
        return courseLService.getItem(id);
    }

    @RequestMapping(value = "/course/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<AcademicVO> getVisit(String language) {
        CourseBLService courseLService=new CourseBL();
        return courseLService.getAllItems(language);
    }

}
