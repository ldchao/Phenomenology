package controller;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/Back_DynamicNews", method = RequestMethod.GET)
    public String backDynamicNews() {
        return "backend/Back_DynamicNews";
    }
}
