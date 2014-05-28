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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 详情页
 * Created by liushuang.ls on 14-4-30.
 */
@Controller
public class DetailController {

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        model.addAttribute("create_time",dateFormat.format(blogEntity.getCreateDatetime()));
        return "detail";
    }

    @RequestMapping("/blog/vote")
    @ResponseBody
    public String addBlog(HttpSession session, int typeId, int voteType) {
        BlogEntity blogEntity = BlogDAO.getBlogByTypeId(typeId);
        int result = -1;
        if(blogEntity != null){
            if(voteType == 1){// 1代表赞成
                blogEntity.setGoodCount(blogEntity.getGoodCount() + 1);
                result = blogEntity.getGoodCount();
            }else if(voteType == 2){// 2代表中立
                blogEntity.setMiddleCount(blogEntity.getMiddleCount() + 1);
                result = blogEntity.getMiddleCount();
            }else if(voteType == 3){// 3代表踩
                blogEntity.setBadCount(blogEntity.getBadCount() + 1);
                result = blogEntity.getBadCount();
            }
            BlogDAO.updateBlogEntity(blogEntity);
        }
        return String.valueOf(result);
    }
}
