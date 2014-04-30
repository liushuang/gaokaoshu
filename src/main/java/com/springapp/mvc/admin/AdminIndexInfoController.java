package com.springapp.mvc.admin;

import com.gaokaoshu.dao.BasicInfoDAO;
import com.gaokaoshu.dao.HotTypeDAO;
import com.gaokaoshu.entity.BasicInfoEntity;
import com.gaokaoshu.entity.HotTypeEntity;
import com.gaokaoshu.util.AdminUtil;
import com.gaokaoshu.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * 管理首页信息
 * Created by LiuShuang on 14-4-13.
 */
@Controller
public class AdminIndexInfoController {
    @RequestMapping("/admin/index/update")
    public String update(ModelMap model, HttpSession session, int id, String text) {
        if (!AdminUtil.isAdmin(session)) {
            model.addAttribute("message", "只有管理员可以进入");
            return "error";
        }
        BasicInfoEntity basicInfoEntity = new BasicInfoEntity();
        basicInfoEntity.setId(id);
        basicInfoEntity.setText(text);
        BasicInfoDAO.update(basicInfoEntity);
        model.addAttribute("resultMessage", "success");
        return "redirect:/admin/adminIndex";
    }

    @RequestMapping("/admin/adminIndex")
    public String index(ModelMap model, HttpSession session) {
        if (!AdminUtil.isAdmin(session)) {
            model.addAttribute("message", "只有管理员可以进入");
            return "error";
        }
        BasicInfoEntity webIntro = BasicInfoDAO.getBasicInfoById(Constant.BASIC_INFO_WEB_INTRODUCTION);
        BasicInfoEntity baokaogaishu = BasicInfoDAO.getBasicInfoById(Constant.BASIC_INFO_BAOKAOGAISHU);
        model.addAttribute("wangzhanshuoming",webIntro.getText());
        model.addAttribute("baokaogaishu",baokaogaishu.getText());

        List<HotTypeEntity> firstHotTypeList = HotTypeDAO.getHotTypeListByLevel(1);
        List<HotTypeEntity> secondHotTypeList = HotTypeDAO.getHotTypeListByLevel(2);
        model.addAttribute("firstHotTypeList",firstHotTypeList);
        model.addAttribute("secondHotTypeList",secondHotTypeList);

        return "adminIndex";
    }

    @RequestMapping(value = "/admin/index/insertHotType",method = RequestMethod.POST)
    public String insertHotType(ModelMap model ,HttpSession session, int typeId, @RequestParam MultipartFile img, int level, String desc) throws IOException {
        if (!AdminUtil.isAdmin(session)) {
            model.addAttribute("message", "只有管理员可以进入");
            return "error";
        }
        String filePath = session.getServletContext().getRealPath("/") + "resources/images/";
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdir();
        }
        String originalFileName = img.getOriginalFilename();
        String localFileName ;
        if(originalFileName.indexOf(".") != -1){
            int separator = originalFileName.lastIndexOf(".");
            localFileName = originalFileName.substring(0,separator) + System.currentTimeMillis() + originalFileName.substring(separator);
        }else{
            localFileName = originalFileName + System.currentTimeMillis();
        }
        File localFile = new File(filePath + localFileName);
        img.transferTo(localFile);
        HotTypeEntity hotTypeEntity = new HotTypeEntity();
        hotTypeEntity.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
        hotTypeEntity.setDescription(desc);
        hotTypeEntity.setTypeId(typeId);
        hotTypeEntity.setTypeLevel(level);
        hotTypeEntity.setImgUrl("/resources/images/" + localFileName);

        HotTypeDAO.insertHotTypeEntity(hotTypeEntity);
        return "redirect:/admin/adminIndex";
    }

    @RequestMapping("/admin/index/deleteHotType")
    public String deleteHotType(ModelMap model ,HttpSession session, int id){
        if (!AdminUtil.isAdmin(session)) {
            model.addAttribute("message", "只有管理员可以进入");
            return "error";
        }
        HotTypeDAO.deleteHotType(id);
        return "redirect:/admin/adminIndex";
    }
}
