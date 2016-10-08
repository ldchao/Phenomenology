package controller;

import ENUM.UniversalState;
import bl.searchBL.SearchBL;
import blservice.searchBLService.SearchBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.AcademicVO;
import vo.AchievementVO;
import vo.OrganizationVO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/6.
 */
@Controller
public class GlobalManagerController {

    //设为版本
    @RequestMapping(value = "/setVersion")
    @ResponseBody
    public String setVersion(String version,HttpServletRequest request){
        request.getSession().setAttribute("Version",version);
        return UniversalState.SUCCEED.toString();
    }


    //得到当前版本
    @RequestMapping(value = "/getVersion")
    @ResponseBody
    public String getVersion(HttpServletRequest request){
        String version=(String)request.getSession().getAttribute("Version");
        if(version==null){
            version="ch";
            request.getSession().setAttribute("Version",version);
        }
        return version;
    }

    //全局搜索文章
    @RequestMapping(value = "/searchEssay")
    @ResponseBody
    public ArrayList<AcademicVO> searchEssay(String key){
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.searchEssay(key);
    }
    //全局搜索科研成果
    @RequestMapping(value = "/searchArticle")
    @ResponseBody
    public ArrayList<AchievementVO> searchArticle(String key){
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.searchArticle(key);
    }
    //全局搜索人员
    @RequestMapping(value = "/searchPerson")
    @ResponseBody
    public ArrayList<OrganizationVO> searchPerson(String key){
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.searchPerson(key);
    }

}
