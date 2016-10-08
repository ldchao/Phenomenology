package controller;

import ENUM.Language;
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
import org.springframework.web.servlet.ModelAndView;
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
    public Integer getLectureID() {
        LectureBLService lectureBLService=new LectureBL();
        return lectureBLService.getID();
    }

    @RequestMapping(value = "/lecture/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateLecture(Integer id,String title,String author,
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
    public String deleteLecture(Integer id) {
        LectureBLService lectureBLService=new LectureBL();
        UniversalState universalState=lectureBLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/lecture/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneLecture(Integer id) {
        LectureBLService lectureBLService=new LectureBL();
        return lectureBLService.getItem(id);
    }

    @RequestMapping(value = "/lecture/detail", method = RequestMethod.GET)
    public ModelAndView getLectureDetail(Integer id) {
        LectureBLService lectureBLService=new LectureBL();
        AcademicVO academicVO=lectureBLService.getItem(id);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("pages/ArticleDetail");

        modelAndView.addObject("AcademicVO", academicVO);
        modelAndView.addObject("Tag1", 3);
        if(academicVO.getLanguage().equals("ch")){
            modelAndView.addObject("Tag2", "学术讲座");
        }else{
            modelAndView.addObject("Tag2", "AcademicForum");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/lecture/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<AcademicVO> getLecture(String language) {
        LectureBLService lectureBLService=new LectureBL();
        return lectureBLService.getAllItems(language);
    }

    @RequestMapping(value = "/communicate/getID", method = RequestMethod.POST)
    @ResponseBody
    public Integer getCommunicateID() {
        CommunicateBLService communicateBLService=new CommunicateBL();
        return communicateBLService.getID();
    }

    @RequestMapping(value = "/communicate/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateCommunicate(Integer id,String title,String author,
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
    public String deleteCommunicate(Integer id) {
        CommunicateBLService communicateBLService=new CommunicateBL();
        UniversalState universalState=communicateBLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/communicate/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneCommunicate(Integer id) {
        CommunicateBLService communicateBLService=new CommunicateBL();
        return communicateBLService.getItem(id);
    }

    @RequestMapping(value = "/communicate/detail", method = RequestMethod.GET)
    public ModelAndView getCommunicateDetail(Integer id) {
        CommunicateBLService communicateBLService=new CommunicateBL();
        AcademicVO academicVO=communicateBLService.getItem(id);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("pages/ArticleDetail");

        modelAndView.addObject("AcademicVO", academicVO);
        modelAndView.addObject("Tag1", 3);
        if(academicVO.getLanguage().equals("ch")){
            modelAndView.addObject("Tag2", "学术会议");
        }else{
            modelAndView.addObject("Tag2", "AcademicConference");
        }
        return modelAndView;
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
    public String updateVisit(Integer id,String title,String author,
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
    public String deleteVisit(Integer id) {
        VisitBLService visitBLService=new VisitBL();
        UniversalState universalState=visitBLService.deleteItem(id);
        return universalState.toString();
    }

    @RequestMapping(value = "/visit/getOne", method = RequestMethod.GET)
    @ResponseBody
    public AcademicVO getOneVisit(Integer id) {
        VisitBLService visitBLService=new VisitBL();
        return visitBLService.getItem(id);
    }


    @RequestMapping(value = "/visit/detail", method = RequestMethod.GET)
    public ModelAndView getVisitDetail(Integer id) {
        VisitBLService visitBLService=new VisitBL();
        AcademicVO academicVO=visitBLService.getItem(id);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("pages/ArticleDetail");

        modelAndView.addObject("AcademicVO", academicVO);
        modelAndView.addObject("Tag1", 3);
        if(academicVO.getLanguage().equals("ch")){
            modelAndView.addObject("Tag2", "师生出访");
        }else{
            modelAndView.addObject("Tag2", "Visitings");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/visit/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<AcademicVO> getVisit(String language) {
        VisitBLService visitBLService=new VisitBL();
        return visitBLService.getAllItems(language);
    }

}
