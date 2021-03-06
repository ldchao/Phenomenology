package controller;

import ENUM.UniversalState;
import bl.helper.UrlManager;
import bl.searchBL.SearchBL;
import blservice.searchBLService.SearchBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.AcademicVO;
import vo.AchievementVO;
import vo.OrganizationVO;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

    //根据输入的关键字全局搜索文章
    @RequestMapping(value = "/searchEssay")
    @ResponseBody
    public ArrayList<AcademicVO> searchEssay(HttpServletRequest request){
        String key = null;
        try {
            key = new String(request.getParameter("key").getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.searchEssay(key);
    }

    //根据热门标签全局搜索文章
    @RequestMapping(value = "/searchEssayByTag")
    @ResponseBody
    public ArrayList<AcademicVO> searchEssayByTag(String tag){
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.searchEssayByTag(tag);
    }

    @RequestMapping(value = "/getEssayURL")
    @ResponseBody
    public String getEssayURL(Integer id){
        return UrlManager.getAcademicUrl(id);
    }

    //全局搜索科研成果
    @RequestMapping(value = "/searchAchievement")
    @ResponseBody
    public ArrayList<AchievementVO> searchArticle(HttpServletRequest request){
        String key = null;
        try {
            key = new String(request.getParameter("key").getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.searchArticle(key);
    }

    //根据热门标签全局搜索科研成果
    @RequestMapping(value = "/searchAchievementByTag")
    @ResponseBody
    public ArrayList<AchievementVO> searchArticleByTag(String tag){
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.searchArticleByTag(tag);
    }

    @RequestMapping(value = "/getAchievementURL")
    @ResponseBody
    public String getArticleURL(Integer id){
        return UrlManager.getAchievementUrl(id);
    }

    //全局搜索人员
    @RequestMapping(value = "/searchPerson")
    @ResponseBody
    public ArrayList<OrganizationVO> searchPerson(HttpServletRequest request){
        String key = null;
        try {
            key = new String(request.getParameter("key").getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.searchPerson(key);
    }

    @RequestMapping(value = "/getPersonURL")
    @ResponseBody
    public String getPersonURL(Integer id){
        return UrlManager.getOrganizationUrl(id);
    }


    @RequestMapping(value = "/getHotTags")
    @ResponseBody
    public List<String> getPersonURL(){
        SearchBLService searchBLService=new SearchBL();
        return searchBLService.getHotTags();
    }

}
