package com.gaogaoshu.dao;

import com.gaokaoshu.dao.TypeDAO;
import com.gaokaoshu.entity.TypeEntity;
import org.junit.Assert;
import org.junit.Test;

/**
 * Type DAO Test
 * Created by LiuShuang on 14-4-19.
 */
public class TypeDAOTest {

    @Test
    public void testGetTypeEntityByName(){
        TypeEntity t = TypeDAO.getTypeEntityByName("test");
        System.out.println(t.getId());
        Assert.assertNotNull(t);
    }
}
