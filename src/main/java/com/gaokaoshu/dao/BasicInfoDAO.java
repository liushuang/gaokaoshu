package com.gaokaoshu.dao;

import com.gaokaoshu.entity.BasicInfoEntity;
import com.gaokaoshu.entity.ViewCountEntity;
import com.gaokaoshu.util.Constant;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Session;

/**
 * Created by liushuang.ls on 14-4-11.
 */
public class BasicInfoDAO {
    public static BasicInfoEntity getBasicInfoById(int id) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        BasicInfoEntity basicInfoEntity = (BasicInfoEntity) session.byId(BasicInfoEntity.class).load(id);
        session.getTransaction().commit();
        session.close();
        return basicInfoEntity;
    }

    public static void update(BasicInfoEntity basicInfoEntity) {
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        // 不可以修改用户名和密码
        if (basicInfoEntity.getId() != Constant.BASIC_INFO_USER_ID && basicInfoEntity.getId() != Constant.BASIC_INFO_PASSWORD) {
            session.saveOrUpdate(basicInfoEntity);
        }
        session.getTransaction().commit();
        session.close();
    }
}
