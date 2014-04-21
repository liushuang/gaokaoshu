package com.gaokaoshu.dao;

import com.gaokaoshu.entity.BasicInfoEntity;
import com.gaokaoshu.entity.TypeEntity;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * 分类的DAO
 * Created by LiuShuang on 14-4-19.
 */
public class TypeDAO {
    public static TypeEntity getTypeById(int id) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        TypeEntity typeEntity = (TypeEntity) session.byId(TypeEntity.class).load(id);
        session.getTransaction().commit();
        session.close();
        return typeEntity;
    }

    public static TypeEntity getTypeEntityByName(String name) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(TypeEntity.class);
        c.add(Restrictions.eq("name", name));
        List<TypeEntity> typeEntityList = c.list();
        if (typeEntityList != null && typeEntityList.size() > 0) {
            return typeEntityList.get(0);
        }

        return null;
    }

    public static void insertTypeEntity(TypeEntity typeEntity) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(TypeEntity.class);
        c.add(Restrictions.eq("name", typeEntity.getName()));
        c.add(Restrictions.eq("level", typeEntity.getLevel()));
        c.add(Restrictions.eq("fid", typeEntity.getfId()));
        List<TypeEntity> existTypeEntityList = c.list();
        if (existTypeEntityList != null && existTypeEntityList.size() > 0) {
            session.close();
            return;
        }
        if(typeEntity.getLevel() == 2){ // 如果是添加学科，首先检查是否有对应的大类
            TypeEntity fType = TypeDAO.getTypeById(typeEntity.getfId());
            if(fType == null){
                return;
            }
        }
        session.save(typeEntity);
        session.getTransaction().commit();
        session.close();
    }

    public static List<TypeEntity> getTypeEntityByLevel(int level){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(TypeEntity.class);
        c.add(Restrictions.eq("level",level));
        return c.list();
    }

    public static void deleteTypeEntity(int id) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        TypeEntity existTypeEntity = (TypeEntity)session.byId(TypeEntity.class).load(id);
        if(existTypeEntity != null){
            if(existTypeEntity.getLevel() == 1){// 如果是学科大类，删除所有小分类
                String sqlDeleteSecondType = "DELETE TypeEntity WHERE fId = ?";
                Query q = session.createQuery(sqlDeleteSecondType);
                q.setInteger(0, existTypeEntity.getId());
                q.executeUpdate();
                session.delete(existTypeEntity);
                session.getTransaction().commit();
            }
        }
        session.close();
    }
}
