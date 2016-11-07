package controller;

import ENUM.Language;
import ENUM.UniversalState;
import bl.helper.FileManager;
import bl.homepageBL.CarouselFigureBL;
import bl.homepageBL.FountainheadBL;
import bl.homepageBL.NewsBL;
import bl.organizationBL.OfficeBearerBL;
import blservice.homepageBLService.CarouselFigureBLService;
import blservice.homepageBLService.FountainheadBLService;
import blservice.homepageBLService.NewsBLService;
import blservice.organizationBLService.OfficeBearerBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import vo.NewsVO;
import vo.OrganizationVO;
import vo.PictureVO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/10/3.
 */

@Controller
@RequestMapping(value = "/homepage")
public class HomepageController {

    @RequestMapping("/CarouselFigure/upload")
    @ResponseBody
    public int uploadCarouselFigure(@RequestParam("carouselFigure") MultipartFile carouselFigure,String url, HttpServletRequest request){

        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "carouselFigure/";

        String filename = carouselFigure.getOriginalFilename();

        FileManager.ensureFileExists(uploadUrl,filename);

        File targetFile = new File(uploadUrl + filename);

        try {
            carouselFigure.transferTo(targetFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String carouselFigurePath="carouselFigure/"+filename;

        PictureVO pictureVO=new PictureVO();
        pictureVO.setLocation(carouselFigurePath);
        if(!url.startsWith("http"))
            url="http://"+url;
        pictureVO.setUrl(url);

        CarouselFigureBLService carouselFigureBLService=new CarouselFigureBL();
        return carouselFigureBLService.addAPicture(pictureVO);
    }

    @RequestMapping("/CarouselFigure/delete")
    @ResponseBody
    public String deleteCarouselFigure(Integer id){
        CarouselFigureBLService carouselFigureBLService=new CarouselFigureBL();
        UniversalState result=carouselFigureBLService.deleteAPicture(id);
        return result.toString();
    }

    @RequestMapping("/CarouselFigure/getOne")
    @ResponseBody
    public PictureVO getOneCarouselFigure(Integer id){
        CarouselFigureBLService carouselFigureBLService=new CarouselFigureBL();
        return carouselFigureBLService.getPicture(id);
    }

    @RequestMapping("/CarouselFigure/getAll")
    @ResponseBody
    public ArrayList<PictureVO> getAllCarouselFigure(){
        CarouselFigureBLService carouselFigureBLService=new CarouselFigureBL();
        return carouselFigureBLService.getAllPicture();
    }

    @RequestMapping(value = "/News/add", method = RequestMethod.POST)
    @ResponseBody
    public Integer addNews(String thumbnailLocation, String url,String language) {
        NewsVO newsVO=new NewsVO();
        newsVO.setThumbnailLocation(thumbnailLocation);
        if(!url.startsWith("http://"))
            url="http://"+url;
        newsVO.setUrl(url);
        newsVO.setLanguage(language);
        NewsBLService newsBLService=new NewsBL();
        return newsBLService.addNews(newsVO);
    }

    @RequestMapping(value = "/News/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateNews(Integer id,String thumbnailLocation, String url,String language) {

        NewsVO newsVO=new NewsVO();
        newsVO.setId(id);
        newsVO.setThumbnailLocation(thumbnailLocation);
        newsVO.setUrl(url);
        newsVO.setLanguage(language);
        NewsBLService newsBLService=new NewsBL();
        UniversalState result=newsBLService.updateNews(newsVO);
        return result.toString();
    }
    @RequestMapping(value = "/News/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteNews(Integer id) {
        NewsBLService newsBLService=new NewsBL();
        UniversalState result=newsBLService.deleteNews(id);
        return result.toString();
    }
    @RequestMapping(value = "/News/sort", method = RequestMethod.POST)
    @ResponseBody
    public String sortNews(@RequestParam("list[]")ArrayList<Integer> list) {
        NewsBLService newsBLService=new NewsBL();
        UniversalState result=newsBLService.sortNews(list);
        return result.toString();
    }
    @RequestMapping(value = "/News/getFive", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<NewsVO> getFiveNews(String language) {
        NewsBLService newsBLService=new NewsBL();
        return newsBLService.getFiveNews(language);
    }

    @RequestMapping(value = "/News/getOne", method = RequestMethod.GET)
    @ResponseBody
    public NewsVO getOneNews(Integer id) {
        NewsBLService newsBLService=new NewsBL();
        return newsBLService.getNews(id);
    }

    @RequestMapping(value = "/News/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<NewsVO> getNews(String language) {
        NewsBLService newsBLService=new NewsBL();
        return newsBLService.getAllNews(language);
    }

    @RequestMapping(value = "/Fountainhead/add", method = RequestMethod.POST)
    @ResponseBody
    public Integer addFountainhead(String thumbnailLocation, String url,String language) {
        NewsVO newsVO=new NewsVO();
        newsVO.setThumbnailLocation(thumbnailLocation);
        if(!url.startsWith("http://"))
            url="http://"+url;
        newsVO.setUrl(url);
        newsVO.setLanguage(language);
        FountainheadBLService fountainheadBLService=new FountainheadBL();
        return fountainheadBLService.addNews(newsVO);
    }

    @RequestMapping(value = "/Fountainhead/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateFountainhead(Integer id,String thumbnailLocation, String url,String language) {

        NewsVO newsVO=new NewsVO();
        newsVO.setId(id);
        newsVO.setThumbnailLocation(thumbnailLocation);
        newsVO.setUrl(url);
        newsVO.setLanguage(language);
        FountainheadBLService fountainheadBLService=new FountainheadBL();
        UniversalState result=fountainheadBLService.updateNews(newsVO);
        return result.toString();
    }
    @RequestMapping(value = "/Fountainhead/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteFountainhead(Integer id) {
        FountainheadBLService fountainheadBLService=new FountainheadBL();
        UniversalState result=fountainheadBLService.deleteNews(id);
        return result.toString();
    }
    @RequestMapping(value = "/Fountainhead/sort", method = RequestMethod.POST)
    @ResponseBody
    public String sortFountainhead(@RequestParam("list[]")ArrayList<Integer> list) {
        FountainheadBLService fountainheadBLService=new FountainheadBL();
        UniversalState result=fountainheadBLService.sortNews(list);
        return result.toString();
    }
    @RequestMapping(value = "/Fountainhead/getFive", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<NewsVO> getFiveFountainhead(String language) {
        FountainheadBLService fountainheadBLService=new FountainheadBL();
        return fountainheadBLService.getFiveNews(language);
    }

    @RequestMapping(value = "/Fountainhead/getOne", method = RequestMethod.GET)
    @ResponseBody
    public NewsVO getOneFountainhead(Integer id) {
        FountainheadBLService fountainheadBLService=new FountainheadBL();
        return fountainheadBLService.getNews(id);
    }

    @RequestMapping(value = "/Fountainhead/get", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<NewsVO> getFountainhead(String language) {
        FountainheadBLService fountainheadBLService=new FountainheadBL();
        return fountainheadBLService.getAllNews(language);
    }


}
