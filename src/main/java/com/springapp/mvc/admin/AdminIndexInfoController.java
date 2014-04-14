package com.springapp.mvc.admin;

import com.gaokaoshu.dao.BasicInfoDAO;
import com.gaokaoshu.entity.BasicInfoEntity;
import com.gaokaoshu.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 管理首页信息
 * Created by LiuShuang on 14-4-13.
 */
@Controller
public class AdminIndexInfoController {
    @RequestMapping("/admin/index/update")
    public String update(ModelMap model, int id, String text) {
        BasicInfoEntity basicInfoEntity = new BasicInfoEntity();
        basicInfoEntity.setId(id);
        basicInfoEntity.setText(text);
        BasicInfoDAO.update(basicInfoEntity);
        model.addAttribute("resultMessage", "success");
        return "adminResult";
    }

    @RequestMapping("/admin/adminIndex")
    public String index(ModelMap model, HttpSession session) {
        if (session.getAttribute(Constant.IS_ADMIN) != null) {
            boolean isAdmin = (Boolean) session.getAttribute(Constant.IS_ADMIN);
            if (!isAdmin) {
                model.addAttribute("message", "only admin can access!");
                return "error";
            }
        }
        return "adminIndex";
    }
}
