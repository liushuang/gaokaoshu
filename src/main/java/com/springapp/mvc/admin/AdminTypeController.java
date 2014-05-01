package com.springapp.mvc.admin;

import com.gaokaoshu.dao.TypeDAO;
import com.gaokaoshu.entity.ResultTypeEntity;
import com.gaokaoshu.entity.TypeEntity;
import com.gaokaoshu.util.AdminUtil;
import com.mysql.jdbc.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理学科大类及学科
 * Created by LiuShuang on 14-4-19.
 */
@Controller
public class AdminTypeController {
    @RequestMapping("/admin/adminType")
    public String adminType(ModelMap model, HttpSession session) {
        if (!AdminUtil.isAdmin(session)) {
            model.addAttribute("message", "只有管理员可以使用");
            return "error";
        }
        List<TypeEntity> firstLevelList = TypeDAO.getTypeEntityByLevel(1);
        List<TypeEntity> secondLevelList = TypeDAO.getTypeEntityByLevel(2);
        List<ResultTypeEntity> resultList = new ArrayList<ResultTypeEntity>();
        if (firstLevelList != null) {
            for (TypeEntity type : firstLevelList) {
                ResultTypeEntity resultTypeEntity = new ResultTypeEntity();
                resultTypeEntity.setTypeEntity(type);
                resultTypeEntity.setChildList(new ArrayList<TypeEntity>());
                resultList.add(resultTypeEntity);
            }
        }
        if (secondLevelList != null) {
            for (TypeEntity child : secondLevelList) {
                for (ResultTypeEntity father : resultList) {
                    if (father.getTypeEntity().getId() == child.getfId()) {
                        father.getChildList().add(child);
                    }
                }
            }
        }
        model.addAttribute("list", resultList);
        return "adminType";
    }

    @RequestMapping("/admin/addFirstType")
    public String addFirstType(ModelMap model, HttpSession session, String name) {
        if (!AdminUtil.isAdmin(session)) {
            model.addAttribute("message", "只有管理员可以使用");
            return "error";
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(name)) {
            model.addAttribute("message", "名称不能为空");
            return "redirect:/admin/adminType";
        }
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setfId(0);
        typeEntity.setLevel(1);
        typeEntity.setName(name);
        TypeDAO.insertTypeEntity(typeEntity);
        return "redirect:/admin/adminType";
    }

    @RequestMapping("/admin/addSecondType")
    public String addSecondType(ModelMap model, HttpSession session, String name, int fid) {
        if (!AdminUtil.isAdmin(session)) {
            model.addAttribute("message", "只有管理员可以使用");
            return "error";
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(name) || fid == 0) {
            model.addAttribute("message", "格式错误");
            return "redirect:/admin/adminType";
        }

        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setfId(fid);
        typeEntity.setLevel(2);
        typeEntity.setName(name);
        TypeDAO.insertTypeEntity(typeEntity);
        return "redirect:/admin/adminType";
    }

    @RequestMapping("/admin/deleteType")
    public String deleteType(ModelMap model, HttpSession session, int id) {
        if (!AdminUtil.isAdmin(session)) {
            model.addAttribute("message", "只有管理员可以使用");
            return "error";
        }
        TypeDAO.deleteTypeEntity(id);
        return "redirect:/admin/adminType";
    }
}
