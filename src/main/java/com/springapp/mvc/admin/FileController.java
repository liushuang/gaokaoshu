package com.springapp.mvc.admin;

import com.gaokaoshu.dao.FileDAO;
import com.gaokaoshu.entity.UploadFileEntity;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 文件上传Controller
 * Created by liushuang.ls on 14-4-23.
 */
@Controller
public class FileController {

    @RequestMapping(value = "/admin/upload", method = RequestMethod.GET)
    public String show() throws IOException {
        return "upload";
    }

    @RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
    public String processUpload(@RequestParam MultipartFile file, Model model, HttpSession session, int blogId, int typeId) throws IOException {
        String filePath = session.getServletContext().getRealPath("/") + "/upload/";
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String originalFileName = file.getOriginalFilename();
        String localFileName;
        if (originalFileName.contains(".")) {
            int separator = originalFileName.lastIndexOf(".");
            localFileName =  System.currentTimeMillis() + originalFileName.substring(separator);
        } else {
            localFileName = String.valueOf(System.currentTimeMillis());
        }
        File localFile = new File(filePath + localFileName);
        UploadFileEntity uploadFileEntity = new UploadFileEntity();
        uploadFileEntity.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
        uploadFileEntity.setBlogId(blogId);
        uploadFileEntity.setTypeId(typeId);
        uploadFileEntity.setFileName(localFile.getName());
        uploadFileEntity.setOriginalName(file.getOriginalFilename());
        uploadFileEntity.setFilePath(localFile.getAbsolutePath());
        file.transferTo(localFile);
        FileDAO.insertFile(uploadFileEntity);
        model.addAttribute("typeId", typeId);
        return "redirect:/admin/adminBlog";
    }

    /**
     * 文件下载
     *
     * @param id 文件id
     * @throws IOException
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> downFile(int id) {
        UploadFileEntity uploadFileEntity = FileDAO.getUploadFileEntityById(id);
        //Http响应头
        HttpHeaders headers = new HttpHeaders();
        if (uploadFileEntity != null) {
            //默认文件名称
            String downFileName = uploadFileEntity.getOriginalName();
            try {
                downFileName = URLEncoder.encode(downFileName, "UTF-8");//转码解决IE下文件名乱码问题
            } catch (Exception e) {
                // ignore
            }

            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", downFileName);

            try {
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(uploadFileEntity.getFilePath())),
                        headers,
                        HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "error.txt");
        return new ResponseEntity<byte[]>("文件不存在.".getBytes(), headers, HttpStatus.OK);
    }

    @RequestMapping("/admin/deleteFile")
    public String deleteFile(Model model, int id) {
        UploadFileEntity uploadFileEntity = FileDAO.getUploadFileEntityById(id);
        int typeId = uploadFileEntity.getTypeId();
        if (uploadFileEntity != null) {
            FileDAO.deleteUploadFile(uploadFileEntity);
        }
        model.addAttribute("typeId", typeId);
        return "redirect:/admin/adminBlog";
    }

    @RequestMapping(value = "/admin/uploadImage", method = RequestMethod.GET)
    public String uploadImage() throws IOException {
        return "uploadImage";
    }

    @RequestMapping(value = "/admin/uploadImage", method = RequestMethod.POST)
    public String uploadImage(@RequestParam MultipartFile file, Model model, HttpSession session) throws IOException {
        String filePath = session.getServletContext().getRealPath("/") + "/resources/images/";
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String originalFileName = file.getOriginalFilename();

        String localFileName = String.valueOf(System.currentTimeMillis());
        if (originalFileName.contains(".")) {
            localFileName = localFileName + originalFileName.substring(originalFileName.indexOf("."));
        }
        File localFile = new File(filePath + localFileName);
        file.transferTo(localFile);
        model.addAttribute("message", "http://www.baokaoshu.com/resources/images/" + localFileName);
        return "uploadImage";
    }
}
