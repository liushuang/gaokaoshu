package com.gaokaoshu.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by liushuang.ls on 14-3-26.
 */
public class SessionFactoryHelper {
    private static SessionFactory sessionFactory;
    static{
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
