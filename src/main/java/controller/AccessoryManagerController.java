package controller;

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
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lvdechao on 2016/9/26.
 */
@Controller
public class AccessoryManagerController {

    @RequestMapping("/uploadEssayAccessory")
    @ResponseBody
    public String uploadEssayAccessory(@RequestParam("accessory") MultipartFile accessory,int id,HttpServletRequest request){

        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "accessory/";
        String originalFilename = accessory.getOriginalFilename();
        String filename = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));

        FileManager.ensureFileExists(uploadUrl,filename);

        File targetFile = new File(uploadUrl + filename);
        try {
            accessory.transferTo(targetFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String accessoryPath="accessory/"+filename;
        AccessoryBLService accessoryBLService=new AccessoryBL();
        AccessoryVO accessoryVO=new AccessoryVO();
        accessoryVO.setTextId(id);
        accessoryVO.setName(originalFilename);
        accessoryVO.setLocation(accessoryPath);
        accessoryBLService.addEssayAccessory(accessoryVO);

        return  accessoryPath;
    }

    @RequestMapping("/uploadSaAccessory")
    @ResponseBody
    public String uploadSaAccessory(@RequestParam("accessory") MultipartFile accessory,int id,HttpServletRequest request){

        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "accessory/";
        String originalFilename = accessory.getOriginalFilename();
        String filename = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));

        FileManager.ensureFileExists(uploadUrl,filename);

        File targetFile = new File(uploadUrl + filename);
        try {
            accessory.transferTo(targetFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String accessoryPath="accessory/"+filename;
        AccessoryBLService accessoryBLService=new AccessoryBL();
        AccessoryVO accessoryVO=new AccessoryVO();
        accessoryVO.setTextId(id);
        accessoryVO.setName(originalFilename);
        accessoryVO.setLocation(accessoryPath);
        accessoryBLService.addSaAccessory(accessoryVO);

        return  accessoryPath;
    }

    @RequestMapping("/getEssayAccessory")
    @ResponseBody
    public ArrayList<AccessoryVO> uploadEssayAccessory(int id){

        AccessoryBLService accessoryBLService=new AccessoryBL();
        return accessoryBLService.getEssayAccessory(id);
    }

    @RequestMapping("/getSaAccessory")
    @ResponseBody
    public ArrayList<AccessoryVO> getSaAccessory(int id){
        AccessoryBLService accessoryBLService=new AccessoryBL();
        return accessoryBLService.getSaAccessory(id);
    }

}
