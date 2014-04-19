package com.gaokaoshu.entity;

import java.util.List;

/**
 * 用于展示学科分类的结果
 * Created by LiuShuang on 14-4-19.
 */
public class ResultTypeEntity {
    private TypeEntity typeEntity;
    private List<TypeEntity> childList;

    public TypeEntity getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(TypeEntity typeEntity) {
        this.typeEntity = typeEntity;
    }

    public List<TypeEntity> getChildList() {
        return childList;
    }

    public void setChildList(List<TypeEntity> childList) {
        this.childList = childList;
    }
}
