package com.springapp.mvc;

import com.gaokaoshu.dao.BlogDAO;
import com.gaokaoshu.dao.TypeDAO;
import com.gaokaoshu.dao.ViewCountDAO;
import com.gaokaoshu.entity.BlogEntity;
import com.gaokaoshu.entity.TypeEntity;
import com.gaokaoshu.util.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

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

    @RequestMapping("/blog/vote")
    @ResponseBody
    public String addBlog(HttpSession session, int typeId, int vote_type) {
        BlogEntity blogEntity = BlogDAO.getBlogByTypeId(typeId);
        if(blogEntity != null){
            if(vote_type == 1){// 1代表赞成
                blogEntity.setGoodCount(blogEntity.getGoodCount() + 1);
            }else if(vote_type == 2){// 2代表中立
                blogEntity.setMiddleCount(blogEntity.getMiddleCount() + 1);
            }else if(vote_type == 3){// 3代表踩
                blogEntity.setBadCount(blogEntity.getBadCount() + 1);
            }
            BlogDAO.updateBlogEntity(blogEntity);
        }
        return "success";
    }
}
