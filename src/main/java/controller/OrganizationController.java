package controller;

import ENUM.UniversalState;
import bl.organizationBL.OfficeBearerBL;
import blservice.organizationBLService.OfficeBearerBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.OrganizationVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/3.
 */

@Controller
@RequestMapping(value = "/organization")
public class OrganizationController {

    @RequestMapping(value = "/officeBearer/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getOfficeBearerID() {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        return officeBearerBLService.getID();
    }

//    @RequestMapping(value = "/officeBearer/addText", method = RequestMethod.POST)
//    @ResponseBody
//    public String addOfficeBearer() {
//
//        return null;
//    }

    @RequestMapping(value = "/officeBearer/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateOfficeBearer(int id,String name,String imageLocation,String descriptionLocation,String language) {

        OrganizationVO organizationVO=new OrganizationVO();
        organizationVO.setId(id);
        organizationVO.setName(name);
        organizationVO.setDescriptionLocation(descriptionLocation);
        organizationVO.setImageLocation(imageLocation);
        organizationVO.setLanguage(language);
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.updateItem(organizationVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/officeBearer/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteOfficeBearer(int id) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.deleteItem(id);
        return universalState.toString();
    }
    @RequestMapping(value = "/officeBearer/sort", method = RequestMethod.POST)
    @ResponseBody
    public String sortOfficeBearer(@RequestParam("list[]")ArrayList<Integer> list) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.sort(list);
        return universalState.toString();
    }
    @RequestMapping(value = "/officeBearer/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<OrganizationVO> getOfficeBearer(String language) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        return officeBearerBLService.getAllItem(language);
    }

    @RequestMapping(value = "/scholar/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getScholarID() {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        return officeBearerBLService.getID();
    }

    @RequestMapping(value = "/scholar/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateScholar(int id,String name,String imageLocation,String descriptionLocation,String language) {

        OrganizationVO organizationVO=new OrganizationVO();
        organizationVO.setId(id);
        organizationVO.setName(name);
        organizationVO.setDescriptionLocation(descriptionLocation);
        organizationVO.setImageLocation(imageLocation);
        organizationVO.setLanguage(language);
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.updateItem(organizationVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/scholar/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteScholar(int id) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.deleteItem(id);
        return universalState.toString();
    }
    @RequestMapping(value = "/scholar/sort", method = RequestMethod.POST)
    @ResponseBody
    public String sortScholar(@RequestParam("list[]")ArrayList<Integer> list) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.sort(list);
        return universalState.toString();
    }
    @RequestMapping(value = "/scholar/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<OrganizationVO> getScholar(String language) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        return officeBearerBLService.getAllItem(language);
    }

    @RequestMapping(value = "/student/getID", method = RequestMethod.POST)
    @ResponseBody
    public int getStudentID() {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        return officeBearerBLService.getID();
    }

    @RequestMapping(value = "/student/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateStudent(int id,String name,String imageLocation,String descriptionLocation,String language) {

        OrganizationVO organizationVO=new OrganizationVO();
        organizationVO.setId(id);
        organizationVO.setName(name);
        organizationVO.setDescriptionLocation(descriptionLocation);
        organizationVO.setImageLocation(imageLocation);
        organizationVO.setLanguage(language);
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.updateItem(organizationVO);
        return universalState.toString();
    }
    @RequestMapping(value = "/student/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteStudent(int id) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.deleteItem(id);
        return universalState.toString();
    }
    @RequestMapping(value = "/student/sort", method = RequestMethod.POST)
    @ResponseBody
    public String sortStudent(@RequestParam("list[]")ArrayList<Integer> list) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        UniversalState universalState=officeBearerBLService.sort(list);
        return universalState.toString();
    }
    @RequestMapping(value = "/student/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<OrganizationVO> getStudent(String language) {
        OfficeBearerBLService officeBearerBLService=new OfficeBearerBL();
        return officeBearerBLService.getAllItem(language);
    }

}
