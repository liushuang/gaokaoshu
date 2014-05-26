package com.springapp.mvc;

import com.gaokaoshu.dao.TypeDAO;
import com.gaokaoshu.entity.ResultTypeEntity;
import com.gaokaoshu.entity.TypeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * list页
 * Created by liushuang.ls on 14-4-30.
 */
@Controller
public class ListController {
    @RequestMapping("/list")
    public String list(ModelMap model, int targetId){
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
        model.addAttribute("type_list", resultList);
        model.addAttribute("targetId", targetId);
        return "list";
    }
}
