package com.gaokaoshu.dao;

import com.gaokaoshu.entity.ViewCountEntity;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Session;

/**
 * 浏览数DAO
 * Created by liushuang.ls on 14-4-11.
 */
public class ViewCountDAO {
    public static int increaseViewCount(int id){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        ViewCountEntity viewCountEntity = (ViewCountEntity) session.byId(ViewCountEntity.class).load(id);
        if(viewCountEntity == null){
            viewCountEntity = new ViewCountEntity();
            viewCountEntity.setId(id);
        }
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
