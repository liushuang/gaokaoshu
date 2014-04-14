package com.springapp.mvc;

import com.gaokaoshu.dao.BasicInfoDAO;
import com.gaokaoshu.entity.BasicInfoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
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
        model.addAttribute("resultMessage","success");
        return "adminResult";
    }

    @RequestMapping("/adminIndex")
    public String index(ModelMap model){
        return "adminIndex";
    }
}
