package controller;

import ENUM.UniversalState;
import bl.helper.FileManager;
import bl.situationBL.SituationBL;
import blservice.situationBLService.SituationBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by lvdechao on 2016/10/5.
 */
@Controller
public class HtmlManagerController {

    @RequestMapping(value = "/uploadHtml", method = RequestMethod.POST)
    @ResponseBody
    public String post(String html,HttpServletRequest request) {
        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "html/";
        String fileName= UUID.randomUUID()+".html";
        FileManager.ensureFileExists(uploadUrl,fileName);
        FileManager.WriteFile(html,uploadUrl,fileName,false);
        return fileName;
    }

    @RequestMapping(value = "/updateHtml", method = RequestMethod.POST)
    @ResponseBody
    public String update(String html,String filename,HttpServletRequest request) {
        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "html/";
        FileManager.ensureFileExists(uploadUrl,filename);
        FileManager.WriteFile(html,uploadUrl,filename,false);
        return UniversalState.SUCCEED.toString();
    }

    @RequestMapping(value = "/getHtml", method = RequestMethod.GET)
    @ResponseBody
    public String get(String filename,HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        String path = request.getSession().getServletContext().getRealPath("/") + "html/"+filename;
        String result=FileManager.ReadFile(path);
        return result;
    }

}
