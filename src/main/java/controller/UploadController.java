package controller;

import ENUM.UniversalState;
import bl.accessoryBL.AccessoryBL;
import bl.helper.FileManager;
import blservice.accessoryBLService.AccessoryBLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import vo.AccessoryVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lvdechao on 2016/9/26.
 */
@Controller
public class UploadController {

    /**
     *前端代码参见CRC头像上传
     */
    @RequestMapping(value = "/uploadImgUrl")
    @ResponseBody
    public String uploadImgUrl(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();

        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "upload/";
        File dir = new File(uploadUrl);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (MultipartFile file :  files.values()) {
            File targetFile = new File(uploadUrl + file.getOriginalFilename());
            if (!targetFile.exists()) {
                try {
                    targetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    file.transferTo(targetFile);
                    return  "/upload/" + file.getOriginalFilename();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return null;
    }

    @RequestMapping("/uploadCover")
    @ResponseBody
    public String uploadCover(@RequestParam("coverImg") MultipartFile coverImg,HttpServletRequest request){

        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "coverImg/";
        String originalFilename = coverImg.getOriginalFilename();
        String filename = UUID.randomUUID()+"";
        if(originalFilename.lastIndexOf(".")>0){
            filename+=originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        FileManager.ensureFileExists(uploadUrl,filename);

        File targetFile = new File(uploadUrl + filename);
        try {
            coverImg.transferTo(targetFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String coverImgPath="http://localhost:8080/Phenomenology/coverImg/"+filename;

        return  coverImgPath;
    }

}
