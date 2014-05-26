package com.springapp.mvc;

import com.gaokaoshu.dao.BlogDAO;
import com.gaokaoshu.dao.TypeDAO;
import com.gaokaoshu.dao.ViewCountDAO;
import com.gaokaoshu.entity.BlogEntity;
import com.gaokaoshu.entity.TypeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 详情页
 * Created by liushuang.ls on 14-4-30.
 */
@Controller
public class DetailController {
    @RequestMapping(value = "/blog/{id}")
    public String blog(ModelMap model, @PathVariable int id) {
        BlogEntity blogEntity = BlogDAO.getBlogByid(id);
        if (blogEntity == null) {
            return "error";
        }
        TypeEntity typeEntity = TypeDAO.getTypeById(blogEntity.getTypeId());
        model.addAttribute("blog", blogEntity);
        model.addAttribute("type", typeEntity);
        return "detail";
    }

    @RequestMapping(value = "/type/{id}")
    public String type(ModelMap model, @PathVariable int id) {
        BlogEntity blogEntity = BlogDAO.getBlogByTypeId(id);
        if (blogEntity == null) {
            return "error";
        }
        TypeEntity typeEntity = TypeDAO.getTypeById(blogEntity.getTypeId());
        int viewCount = ViewCountDAO.increaseViewCount(id);
        model.addAttribute("blog", blogEntity);
        model.addAttribute("type", typeEntity);
        model.addAttribute("viewCount",viewCount);
        return "detail";
    }
}
