package controller;

import bl.situationBL.SituationBL;
import blservice.situationBLService.SituationBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lvdechao on 2016/10/3.
 */

@Controller
@RequestMapping(value = "/situation")
public class SituationController {


    @RequestMapping(value = "/uploadHtml", method = RequestMethod.POST)
    public void post(String html,String language,HttpServletRequest request) {
        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "html/situation/";
        String fileName=language+".html";
        SituationBLService situationBLService=new SituationBL();
        situationBLService.updateSituation(html,uploadUrl,fileName);

    }

    @RequestMapping(value = "/getHtml", method = RequestMethod.GET)
    @ResponseBody
    public String get(String language,HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        String path = request.getSession().getServletContext().getRealPath("/") + "html/situation/"+language+".html";
        SituationBLService situationBLService=new SituationBL();
        String result=situationBLService.getSituation(path);
        return result;
    }
}
