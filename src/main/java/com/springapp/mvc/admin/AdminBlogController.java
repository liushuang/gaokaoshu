package com.springapp.mvc.admin;

import com.gaokaoshu.dao.BlogDAO;
import com.gaokaoshu.entity.BlogEntity;
import com.gaokaoshu.util.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * 管理日志Controller
 * Created by LiuShuang on 14-4-19.
 */
@Controller
public class AdminBlogController {
    @RequestMapping("/admin/adminBlog")
    public String adminBlog(ModelMap model, HttpSession session, int blogId) {
        if (!AdminUtil.isAdmin(session)) {
            if (!AdminUtil.isAdmin(session)) {
                model.addAttribute("message", "只有管理员可以使用");
                return "error";
            }
        }
        BlogEntity blogEntity = BlogDAO.getBlogByid(blogId);
        model.addAttribute("blog",blogEntity);
        return "adminBlog";
    }

    @RequestMapping("/admin/addBlog")
    public String addBlog(ModelMap model, HttpSession session, int typeId, String content){
        if (!AdminUtil.isAdmin(session)) {
            if (!AdminUtil.isAdmin(session)) {
                model.addAttribute("message", "只有管理员可以使用");
                return "error";
            }
        }
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
        blogEntity.setText(content);
        blogEntity.setTypeId(typeId);
        BlogDAO.insertBlogEntity(blogEntity);
        return "redirect:/admin/adminType";
    }
}
