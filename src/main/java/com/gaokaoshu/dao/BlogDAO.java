package com.gaokaoshu.dao;

import com.gaokaoshu.entity.BasicInfoEntity;
import com.gaokaoshu.entity.BlogEntity;
import com.gaokaoshu.entity.TypeEntity;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * 日志DAO
 * Created by LiuShuang on 14-4-19.
 */
public class BlogDAO {
    public static BlogEntity getBlogByid(int id){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        BlogEntity blogEntity = (BlogEntity) session.byId(BasicInfoEntity.class).load(id);
        session.getTransaction().commit();
        session.close();
        return blogEntity;
    }

    public static void insertBlogEntity(BlogEntity blogEntity){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(BlogEntity.class);
        c.add(Restrictions.eq("type_id", blogEntity.getTypeId()));
        List<BlogEntity> blogEntityList = c.list();
        if (blogEntityList != null && blogEntityList.size() > 0) {
            return;
        }
        session.save(blogEntity);
        session.getTransaction().commit();
        session.close();
    }
    public static BlogEntity getBlogByTypeId(int typeId){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(BlogEntity.class);
        c.add(Restrictions.eq("type_id", typeId));
        List<BlogEntity> blogEntityList = c.list();
        if (blogEntityList != null && blogEntityList.size() > 0) {
            return blogEntityList.get(0);
        }
        session.close();
        return null;
    }
}
