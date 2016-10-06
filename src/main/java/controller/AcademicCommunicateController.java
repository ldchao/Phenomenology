package controller;

import ENUM.UniversalState;
import bl.academicCommunicateBL.CommunicateBL;
import bl.academicCommunicateBL.LectureBL;
import bl.academicCommunicateBL.VisitBL;
import bl.organizationBL.OfficeBearerBL;
import blservice.academicCommunicateBLService.CommunicateBLService;
import blservice.academicCommunicateBLService.LectureBLService;
import blservice.academicCommunicateBLService.VisitBLService;
import blservice.organizationBLService.OfficeBearerBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.AcademicVO;
import vo.OrganizationVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/3.
 */

@Controller
@RequestMapping(value = "/academicCommunicate")
public class AcademicCommunicateController {


    @RequestMapping(value = "/lecture/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getLectureID() {
        LectureBLService lectureBLService=new LectureBL();
        return lectureBLService.getID();
    }

    @RequestMapping(value = "/lecture/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateLecture(int id,String title,String author,
                                String location,String language) {

        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(id);
        academicVO.setTitle(title);
        academicVO.setAuthor(author);
        academicVO.setLocation(location);
        academicVO.setLanguage(language);
        LectureBLService lectureBLService=new LectureBL();
        UniversalState universalState=lectureBLService.updateItem(academicVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/lecture/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteLecture(int id) {
        LectureBLService lectureBLService=new LectureBL();
        UniversalState universalState=lectureBLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/lecture/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneLecture(int id) {
        LectureBLService lectureBLService=new LectureBL();
        return lectureBLService.getItem(id);
    }

    @RequestMapping(value = "/lecture/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<AcademicVO> getLecture(String language) {
        LectureBLService lectureBLService=new LectureBL();
        return lectureBLService.getAllItems(language);
    }

    @RequestMapping(value = "/communicate/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getCommunicateID() {
        CommunicateBLService communicateBLService=new CommunicateBL();
        return communicateBLService.getID();
    }

    @RequestMapping(value = "/communicate/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateCommunicate(int id,String title,String author,
                                String location,String language) {

        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(id);
        academicVO.setTitle(title);
        academicVO.setAuthor(author);
        academicVO.setLocation(location);
        academicVO.setLanguage(language);
        CommunicateBLService communicateBLService=new CommunicateBL();
        UniversalState universalState=communicateBLService.updateItem(academicVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/communicate/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCommunicate(int id) {
        CommunicateBLService communicateBLService=new CommunicateBL();
        UniversalState universalState=communicateBLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/communicate/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneCommunicate(int id) {
        CommunicateBLService communicateBLService=new CommunicateBL();
        return communicateBLService.getItem(id);
    }

    @RequestMapping(value = "/communicate/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<AcademicVO> getCommunicate(String language) {
        CommunicateBLService communicateBLService=new CommunicateBL();
        return communicateBLService.getAllItems(language);
    }

    @RequestMapping(value = "/visit/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getVisitID() {
        VisitBLService visitBLService=new VisitBL();
        return visitBLService.getID();
    }

    @RequestMapping(value = "/visit/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateVisit(int id,String title,String author,
                                String location,String language) {

        AcademicVO academicVO=new AcademicVO();
        academicVO.setId(id);
        academicVO.setTitle(title);
        academicVO.setAuthor(author);
        academicVO.setLocation(location);
        academicVO.setLanguage(language);
        VisitBLService visitBLService=new VisitBL();
        UniversalState universalState=visitBLService.updateItem(academicVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/visit/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteVisit(int id) {
        VisitBLService visitBLService=new VisitBL();
        UniversalState universalState=visitBLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/visit/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneVisit(int id) {
        VisitBLService visitBLService=new VisitBL();
        return visitBLService.getItem(id);
    }

    @RequestMapping(value = "/visit/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<AcademicVO> getVisit(String language) {
        VisitBLService visitBLService=new VisitBL();
        return visitBLService.getAllItems(language);
    }

}
