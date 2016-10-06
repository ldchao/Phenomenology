package controller;

import ENUM.UniversalState;
import bl.helper.FileManager;
import bl.homepageBL.CarouselFigureBL;
import blservice.homepageBLService.CarouselFigureBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import vo.PictureVO;

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

        String carouselFigurePath="../carouselFigure/"+filename;

        PictureVO pictureVO=new PictureVO();
        pictureVO.setLocation(carouselFigurePath);
        pictureVO.setUrl(url);

        CarouselFigureBLService carouselFigureBLService=new CarouselFigureBL();
        return carouselFigureBLService.addAPicture(pictureVO);
    }

    @RequestMapping("/CarouselFigure/delete")
    @ResponseBody
    public String deleteCarouselFigure(int id){
        CarouselFigureBLService carouselFigureBLService=new CarouselFigureBL();
        UniversalState result=carouselFigureBLService.deleteAPicture(id);
        return result.toString();
    }

    @RequestMapping("/CarouselFigure/getAll")
    @ResponseBody
    public ArrayList<PictureVO> getAllCarouselFigure(){
        CarouselFigureBLService carouselFigureBLService=new CarouselFigureBL();
        return carouselFigureBLService.getAllPicture();
    }



}
