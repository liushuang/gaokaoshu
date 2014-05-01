package com.springapp.mvc.admin;

import com.gaokaoshu.dao.BlogDAO;
import com.gaokaoshu.entity.BlogEntity;
import com.gaokaoshu.util.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理日志Controller
 * Created by LiuShuang on 14-4-19.
 */
@Controller
public class AdminBlogController {
    @RequestMapping("/admin/adminBlog")
    public String adminBlog(ModelMap model, HttpSession session, @RequestParam(value = "blogId", required = false, defaultValue = "0") int blogId, @RequestParam(value = "typeId", required = false, defaultValue = "0") int typeId) {
        if (!AdminUtil.isAdmin(session)) {
            if (!AdminUtil.isAdmin(session)) {
                model.addAttribute("message", "只有管理员可以使用");
                return "error";
            }
        }
        BlogEntity blogEntity = null;
        if (blogId != 0) {
            blogEntity = BlogDAO.getBlogByid(blogId);
        } else if (typeId != 0) {
            blogEntity = BlogDAO.getBlogByTypeId(typeId);
        }
        model.addAttribute("blog", blogEntity);
        model.addAttribute("typeId", typeId);
        model.addAttribute("blogId", blogId);
        return "adminBlog";
    }

    @RequestMapping("/admin/addBlog")
    @ResponseBody
    public String addBlog(HttpSession session, int typeId, String content) {
        if (!AdminUtil.isAdmin(session)) {
            if (!AdminUtil.isAdmin(session)) {
                return "need login";
            }
        } else {
            BlogEntity blogEntity = new BlogEntity();
            blogEntity.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
            blogEntity.setContent(content);
            blogEntity.setTypeId(typeId);
            BlogDAO.insertBlogEntity(blogEntity);
        }
        return "success";
    }

    @RequestMapping("/admin/getBlogContent")
    @ResponseBody
    public String getContentByBlogId(int blogId) {
        BlogEntity blogEntity = BlogDAO.getBlogByid(blogId);
        if (blogEntity != null) {
            return blogEntity.getContent();
        }
        return "";
    }

    @RequestMapping("/admin/editBlog")
    public String editBlog(ModelMap model, HttpSession session, int blogId, String content) {
        if (!AdminUtil.isAdmin(session)) {
            if (!AdminUtil.isAdmin(session)) {
                model.addAttribute("message", "只有管理员可以使用");
                return "error";
            }
        }

        BlogEntity blogEntity = BlogDAO.getBlogByid(blogId);
        if (blogEntity != null) {
            blogEntity.setContent(content);
            blogEntity.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
            BlogDAO.updateBlogEntity(blogEntity);
        }
        return "redirect:/admin/adminType";
    }
}
