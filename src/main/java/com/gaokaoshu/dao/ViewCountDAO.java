package com.gaokaoshu.dao;

import com.gaokaoshu.entity.ViewCountEntity;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Session;

/**
 * Created by liushuang.ls on 14-4-11.
 */
public class ViewCountDAO {
    public static int increateViewCount(int id){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        ViewCountEntity viewCountEntity = (ViewCountEntity) session.byId(ViewCountEntity.class).load(id);
        viewCountEntity.setCount(viewCountEntity.getCount() + 1);
        session.saveOrUpdate(viewCountEntity);
        session.getTransaction().commit();
        session.close();
        return viewCountEntity.getCount();
    }

    public static int getViewCount(int id){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        ViewCountEntity viewCountEntity = (ViewCountEntity) session.byId(ViewCountEntity.class).load(id);
        session.close();
        return viewCountEntity.getCount();
    }
}