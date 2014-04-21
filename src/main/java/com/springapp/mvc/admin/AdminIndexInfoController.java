package com.springapp.mvc.admin;

import com.gaokaoshu.dao.BasicInfoDAO;
import com.gaokaoshu.entity.BasicInfoEntity;
import com.gaokaoshu.util.AdminUtil;
import com.gaokaoshu.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
        return "adminIndex";
    }
}
