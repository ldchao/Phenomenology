package controller;

import bl.academicCommunicateBL.LectureBL;
import blservice.academicCommunicateBLService.LectureBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vo.AcademicVO;

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

    @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public ModelAndView searchResult(String key) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages/SearchResult");
        modelAndView.addObject("key", key);
        return modelAndView;
    }

    //后台部分
    @RequestMapping(value = "/Introduce", method = RequestMethod.GET)
    public String introduce() {
        return "backend/Introduce";
    }

    @RequestMapping(value = "/DynamicNews", method = RequestMethod.GET)
    public String dynamicNews() {
        return "backend/DynamicNews";
    }

    @RequestMapping(value = "/WaterSource", method = RequestMethod.GET)
    public String waterSource() {
        return "backend/WaterSource";
    }

    @RequestMapping(value = "/RollImage", method = RequestMethod.GET)
    public String rollImage() {
        return "backend/RollImage";
    }

    @RequestMapping(value = "/Worker", method = RequestMethod.GET)
    public String worker() {
        return "backend/Worker";
    }

    @RequestMapping(value = "/Visitor", method = RequestMethod.GET)
    public String visitor() {
        return "backend/Visitor";
    }

    @RequestMapping(value = "/Student", method = RequestMethod.GET)
    public String student() {
        return "backend/Student";
    }

    @RequestMapping(value = "/Lecture", method = RequestMethod.GET)
    public String lecture() {
        return "backend/Lecture";
    }

    @RequestMapping(value = "/Meeting", method = RequestMethod.GET)
    public String meeting() {
        return "backend/Meeting";
    }

    @RequestMapping(value = "/Visiting", method = RequestMethod.GET)
    public String visiting() {
        return "backend/Visiting";
    }

    @RequestMapping(value = "/LectureRecord", method = RequestMethod.GET)
    public String lectureRecord() {
        return "backend/LectureRecord";
    }

    @RequestMapping(value = "/Course", method = RequestMethod.GET)
    public String course() {
        return "backend/Course";
    }

    @RequestMapping(value = "/AcademicNews", method = RequestMethod.GET)
    public String academicNews() {
        return "backend/AcademicNews";
    }

    @RequestMapping(value = "/Book", method = RequestMethod.GET)
    public String book() {
        return "backend/Book";
    }

    @RequestMapping(value = "/Article", method = RequestMethod.GET)
    public String article() {
        return "backend/Article";
    }

}
