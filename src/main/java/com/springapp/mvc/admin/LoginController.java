package com.springapp.mvc.admin;

import com.gaokaoshu.dao.BasicInfoDAO;
import com.gaokaoshu.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 管理员登陆
 * Created by LiuShuang on 14-4-14.
 */
@Controller
public class LoginController {
    @RequestMapping("/admin/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/admin/check", method = RequestMethod.POST)
    public String check(HttpSession session, String id, String password, ModelMap model) {
        String requiredId = BasicInfoDAO.getBasicInfoById(Constant.BASIC_INFO_USER_ID).getText();
        String requiredPassword = BasicInfoDAO.getBasicInfoById(Constant.BASIC_INFO_PASSWORD).getText();
        if (requiredId.equals(id) && requiredPassword.equals(password)) {
            session.setAttribute(Constant.IS_ADMIN, true);
            return "redirect:/admin/adminIndex";
        }
        model.addAttribute("message", "error id or password");
        session.setAttribute(Constant.IS_ADMIN, false);
        return "error";
    }

}
