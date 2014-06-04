package com.springapp.mvc.admin;

import com.gaokaoshu.dao.BlogDAO;
import com.gaokaoshu.dao.FileDAO;
import com.gaokaoshu.entity.BlogEntity;
import com.gaokaoshu.entity.UploadFileEntity;
import com.gaokaoshu.util.AdminUtil;
import org.apache.commons.io.monitor.FileEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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
            if (blogEntity != null) {
                model.addAttribute("typeId", blogEntity.getTypeId());
                model.addAttribute("blogId", blogEntity.getId());
            } else {
                model.addAttribute("typeId", typeId);
                model.addAttribute("blogId", blogId);
            }
        } else if (typeId != 0) {
            blogEntity = BlogDAO.getBlogByTypeId(typeId);
            if (blogEntity != null) {
                model.addAttribute("typeId", blogEntity.getTypeId());
                model.addAttribute("blogId", blogEntity.getId());
            } else {
                model.addAttribute("typeId", typeId);
                model.addAttribute("blogId", blogId);
            }
        } else {
            model.addAttribute("typeId", typeId);
            model.addAttribute("blogId", blogId);
        }
        model.addAttribute("blog", blogEntity);
        List<UploadFileEntity> fileEntryList = FileDAO.getUploadFileEntityByTypeId(typeId);
        model.addAttribute("fileList", fileEntryList);
        return "adminBlog";
    }

    @RequestMapping("/admin/addBlog")
    public String addBlog(ModelMap model, HttpSession session, int typeId, String content) {
        if (!AdminUtil.isAdmin(session)) {
            if (!AdminUtil.isAdmin(session)) {
                return "error";
            }
        } else {

            BlogEntity blogEntity = null;
            blogEntity = BlogDAO.getBlogByTypeId(typeId);
            if (blogEntity == null) {
                blogEntity = new BlogEntity();
                blogEntity.setGoodCount(0);
                blogEntity.setMiddleCount(0);
                blogEntity.setBadCount(0);
            }
            blogEntity.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
            blogEntity.setContent(content);
            blogEntity.setTypeId(typeId);
            blogEntity.setId(typeId);
            BlogDAO.insertBlogEntity(blogEntity);
        }
        model.addAttribute("typeId", typeId);
        return "redirect:/admin/adminBlog";
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
    @ResponseBody
    public String editBlog(HttpSession session, int blogId, String content, String authorName) {
        if (!AdminUtil.isAdmin(session)) {
            if (!AdminUtil.isAdmin(session)) {
                return "need login";
            }
        }

        BlogEntity blogEntity = BlogDAO.getBlogByid(blogId);
        if (blogEntity != null) {
            blogEntity.setContent(content);
            blogEntity.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
            blogEntity.setAuthorName(authorName);
            BlogDAO.updateBlogEntity(blogEntity);
        }
        return "success";
    }
}
