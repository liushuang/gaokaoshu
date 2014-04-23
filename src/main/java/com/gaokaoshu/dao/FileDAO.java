package com.gaokaoshu.dao;

import com.gaokaoshu.entity.BlogEntity;
import com.gaokaoshu.entity.UploadFileEntity;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by liushuang.ls on 14-4-23.
 */
public class FileDAO {
    /**
     * 插入一条记录
     *
     * @param uploadFileEntity
     */
    public static void insertFile(UploadFileEntity uploadFileEntity) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(uploadFileEntity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * 根据日志id获取文件列表
     *
     * @param blogId 日志id
     * @return 日志对应的文件列表
     */
    public static List<UploadFileEntity> getUploadFileEntityByBlogId(int blogId) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(UploadFileEntity.class);
        c.add(Restrictions.eq("blog_id", blogId));
        return c.list();
    }

}
