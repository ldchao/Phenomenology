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

    @RequestMapping(value = "/HomePage", method = RequestMethod.GET)
    public String homePages() {
        return "HomePage";
    }

    @RequestMapping(value = "/AcademicCommunicate", method = RequestMethod.GET)
    public String academicCommunicate() {
        return "AcademicCommunicate";
    }

    @RequestMapping(value = "/AcademicSource", method = RequestMethod.GET)
    public String academicSource() {
        return "AcademicSource";
    }
    @RequestMapping(value = "/Achievement", method = RequestMethod.GET)
    public String achievement() {
        return "Achievement";
    }
    @RequestMapping(value = "/Organization", method = RequestMethod.GET)
    public String organization() {
        return "Organization";
    }
    @RequestMapping(value = "/Situation", method = RequestMethod.GET)
    public String situation() {
        return "Situation";
    }
}
