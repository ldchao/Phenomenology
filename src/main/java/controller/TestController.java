package controller;

import DaoImpl.HomepageDaoImpl;
import POJO.Homepage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mm on 2016/10/6.
 */
@Controller
public class TestController {
    @RequestMapping(value="/test")
    public void test(){
        Homepage homepage=new Homepage();
        homepage.setId(3);
//        homepage.setLanguage("English");
        homepage.setType("none");
        HomepageDaoImpl homepageDao=new HomepageDaoImpl();
        homepageDao.pesist(homepage);
    }

}
