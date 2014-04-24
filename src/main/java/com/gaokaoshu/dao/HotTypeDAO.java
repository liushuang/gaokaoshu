package com.gaokaoshu.dao;

import com.gaokaoshu.entity.HotTypeEntity;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * 热门学科DAO
 * Created by liushuang.ls on 14-4-24.
 */
public class HotTypeDAO {
    /**
     * 插入一条热门学科记录
     *
     * @param hotTypeEntity
     */
    public static void insertHotTypeEntity(HotTypeEntity hotTypeEntity) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(hotTypeEntity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * 删除一条热门学科记录
     *
     * @param id
     */
    public static void deleteHotType(int id) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        HotTypeEntity hotTypeEntity = (HotTypeEntity) session.byId(HotTypeEntity.class).load(id);
        session.delete(hotTypeEntity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * 获取热门学科的list
     *
     * @param level 1：热门分类 2：热门学科
     * @return
     */
    public static List<HotTypeEntity> getHotTypeListByLevel(int level) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(HotTypeEntity.class);
        c.add(Restrictions.eq("typeLevel", level));
        return c.list();
    }
}
