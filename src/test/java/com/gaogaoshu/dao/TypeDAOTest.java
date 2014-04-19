package com.gaogaoshu.dao;

import com.gaokaoshu.dao.TypeDAO;
import com.gaokaoshu.entity.TypeEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Type DAO Test
 * Created by LiuShuang on 14-4-19.
 */
public class TypeDAOTest {

    @Test
    public void testGetTypeEntityByName(){
        TypeEntity t = TypeDAO.getTypeEntityByName("test");
        Assert.assertNotNull(t);
    }

    @Test
    public void testGetTypeEntityByLevel(){
        List<TypeEntity> list = TypeDAO.getTypeEntityByLevel(1);
        Assert.assertNotNull(list);
    }

    @Test
    public void testGetTypeEntityById(){
        TypeEntity t = TypeDAO.getTypeById(1);
        Assert.assertNotNull(t);
    }
}
