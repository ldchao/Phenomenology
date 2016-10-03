package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lvdechao on 2016/10/3.
 */

@Controller
@RequestMapping(value = "/situation")
public class SituationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void index(){}
}
