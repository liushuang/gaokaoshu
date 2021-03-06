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
     * @param typeId 学科分类id
     * @return 日志对应的文件列表
     */
    public static List<UploadFileEntity> getUploadFileEntityByTypeId(int typeId) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(UploadFileEntity.class);
        c.add(Restrictions.eq("typeId", typeId));
        return c.list();
    }

    public static UploadFileEntity getUploadFileEntityById(int id){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        UploadFileEntity uploadFileEntity = (UploadFileEntity) session.byId(UploadFileEntity.class).load(id);
        session.getTransaction().commit();
        session.close();
        return uploadFileEntity;
    }

    /**
     * 删除一个文件
     * @param uploadFileEntity
     */
    public static void deleteUploadFile(UploadFileEntity uploadFileEntity ){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(uploadFileEntity);
        session.getTransaction().commit();
        session.close();
    }
}
