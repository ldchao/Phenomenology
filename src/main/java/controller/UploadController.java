package controller;

import ENUM.UniversalState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

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
                    return  "http://localhost:8082/upload/" + file.getOriginalFilename();
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
    public String uploadCover(@RequestParam("coverImg") MultipartFile coverImg, @RequestParam("articleId") String articleId, HttpServletRequest request){

        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "coverImg/";
        String originalName = coverImg.getOriginalFilename();
        String nameSplit[]=originalName.split("\\.");
        int index=nameSplit.length-1;
        String filename =articleId;
        if(index>0)
            filename+="."+nameSplit[index];

        File dir = new File(uploadUrl);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        System.out.println("文件上传到: " + uploadUrl + filename);

        File targetFile = new File(uploadUrl + filename);
        if (!targetFile.exists()) {
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return UniversalState.FAIL.toString();
            }
        }

        try {
            coverImg.transferTo(targetFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return UniversalState.FAIL.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return UniversalState.FAIL.toString();
        }

        String coverImgPath="../coverImg/"+filename;

        return  coverImgPath;
    }
}
