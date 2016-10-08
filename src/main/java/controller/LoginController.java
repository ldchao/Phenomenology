package controller;

import ENUM.UniversalState;
import bl.loginBL.LoginBL;
import blservice.loginBLService.LoginBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lvdechao on 2016/10/8.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/Login")
    @ResponseBody
    public String login(String name, String password, HttpServletRequest request){
        LoginBLService loginBLService=new LoginBL();
        UniversalState result=loginBLService.login(name,password);
        if(result==UniversalState.SUCCEED){
            request.getSession().setAttribute("User",name);
        }
        return result.toString();
    }

    @RequestMapping(value = "/ChangePassword")
    @ResponseBody
    public String login(String name,String oldPassword,String newPassword){
        LoginBLService loginBLService=new LoginBL();
        UniversalState result=loginBLService.changePassword(name,oldPassword,newPassword);
        return result.toString();
    }

    @RequestMapping(value = "/Logout")
    @ResponseBody
    public String logout( HttpServletRequest request){
        request.getSession().setAttribute("User",null);
        return UniversalState.SUCCEED.toString();
    }
}
