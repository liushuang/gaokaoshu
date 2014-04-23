package com.springapp.mvc.admin;

import com.gaokaoshu.entity.UploadFileEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 文件上传Controller
 * Created by liushuang.ls on 14-4-23.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/admin/upload", method = RequestMethod.GET)
    public String show() throws IOException {
        return "upload";
    }

    @RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
    public String processUpload(@RequestParam MultipartFile file, Model model, HttpSession session, int blogId) throws IOException {
        String filePath = session.getServletContext().getRealPath("/") + "upload/";
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdir();
        }
        File localFile = new File(filePath + file.getOriginalFilename());
        UploadFileEntity uploadFileEntity = new UploadFileEntity();
        uploadFileEntity.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
        uploadFileEntity.setBlogId(blogId);
        uploadFileEntity.setFileName(localFile.getName());
        uploadFileEntity.setOriginalName(file.getOriginalFilename());
        uploadFileEntity.setFilePath(localFile.getAbsolutePath());
        file.transferTo(localFile);
        model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
        return "upload";
    }


}
