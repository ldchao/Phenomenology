package controller;

import bl.academicCommunicateBL.LectureBL;
import blservice.academicCommunicateBLService.LectureBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vo.AcademicVO;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by lvdechao on 2016/7/7.
 */

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "pages/HomePage";
    }

    @RequestMapping(value = "/HomePage", method = RequestMethod.GET)
    public String homePages() {
        return "pages/HomePage";
    }

    @RequestMapping(value = "/AcademicCommunicate", method = RequestMethod.GET)
    public String academicCommunicate() {
        return "pages/AcademicCommunicate";
    }

    @RequestMapping(value = "/AcademicSource", method = RequestMethod.GET)
    public String academicSource() {
        return "pages/AcademicSource";
    }

    @RequestMapping(value = "/Achievement", method = RequestMethod.GET)
    public String achievement() {
        return "pages/Achievement";
    }

    @RequestMapping(value = "/Organization", method = RequestMethod.GET)
    public String organization() {
        return "pages/Organization";
    }

    @RequestMapping(value = "/Situation", method = RequestMethod.GET)
    public String situation() {
        return "pages/Situation";
    }

    @RequestMapping(value = "/Blogroll", method = RequestMethod.GET)
    public String blogroll() {
        return "pages/Blogroll";
    }

    @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public ModelAndView searchResult(HttpServletRequest request) {
        String key = null;
        try {
            key = new String(request.getParameter("key").getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages/SearchResult");
        modelAndView.addObject("key", key);
        return modelAndView;
    }

    //后台部分
    @RequestMapping(value = "/Introduce", method = RequestMethod.GET)
    public String introduce(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Introduce";
    }

    @RequestMapping(value = "/DynamicNews", method = RequestMethod.GET)
    public String dynamicNews(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/DynamicNews";
    }

    @RequestMapping(value = "/WaterSource", method = RequestMethod.GET)
    public String waterSource(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/WaterSource";
    }

    @RequestMapping(value = "/RollImage", method = RequestMethod.GET)
    public String rollImage(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/RollImage";
    }

    @RequestMapping(value = "/Worker", method = RequestMethod.GET)
    public String worker(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Worker";
    }

    @RequestMapping(value = "/Visitor", method = RequestMethod.GET)
    public String visitor(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Visitor";
    }

    @RequestMapping(value = "/Student", method = RequestMethod.GET)
    public String student(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Student";
    }

    @RequestMapping(value = "/Lecture", method = RequestMethod.GET)
    public String lecture(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Lecture";
    }

    @RequestMapping(value = "/Meeting", method = RequestMethod.GET)
    public String meeting(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Meeting";
    }

    @RequestMapping(value = "/Visiting", method = RequestMethod.GET)
    public String visiting(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Visiting";
    }

    @RequestMapping(value = "/LectureRecord", method = RequestMethod.GET)
    public String lectureRecord(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/LectureRecord";
    }

    @RequestMapping(value = "/Course", method = RequestMethod.GET)
    public String course(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Course";
    }

    @RequestMapping(value = "/AcademicNews", method = RequestMethod.GET)
    public String academicNews(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/AcademicNews";
    }

    @RequestMapping(value = "/Book", method = RequestMethod.GET)
    public String book(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Book";
    }

    @RequestMapping(value = "/Article", method = RequestMethod.GET)
    public String article(HttpServletRequest request) {
        if(request.getSession().getAttribute("User")==null)
            return "backend/Login";
        return "backend/Article";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String login() {
        return "backend/Login";
    }

}
