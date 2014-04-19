package com.springapp.mvc.admin;

import com.gaokaoshu.dao.TypeDAO;
import com.gaokaoshu.entity.ResultTypeEntity;
import com.gaokaoshu.entity.TypeEntity;
import com.gaokaoshu.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理学科大类及学科
 * Created by LiuShuang on 14-4-19.
 */
@Controller
public class AdminTypeController {
    @RequestMapping("/admin/adminType")
    public String adminType(ModelMap model, HttpSession session){
        if (session.getAttribute(Constant.IS_ADMIN) != null) {
            boolean isAdmin = (Boolean) session.getAttribute(Constant.IS_ADMIN);
            if (!isAdmin) {
                model.addAttribute("message", "only admin can access!");
                return "error";
            }
        }
        List<TypeEntity> firstLevelList = TypeDAO.getTypeEntityByLevel(1);
        List<TypeEntity> secondLevelList = TypeDAO.getTypeEntityByLevel(2);
        List<ResultTypeEntity> resultList = new ArrayList<ResultTypeEntity>();
        if(firstLevelList != null){
            for(TypeEntity type : firstLevelList){
                ResultTypeEntity resultTypeEntity = new ResultTypeEntity();
                resultTypeEntity.setTypeEntity(type);
                resultTypeEntity.setChildList(new ArrayList<TypeEntity>());
                resultList.add(resultTypeEntity);
            }
        }
        if(secondLevelList != null){
            for(TypeEntity child : secondLevelList){
                for(ResultTypeEntity father : resultList){
                    if(father.getTypeEntity().getId() == child.getfId()){
                        father.getChildList().add(child);
                    }
                }
            }
        }
        model.addAttribute("list",resultList);
        return "adminType";
    }
}
