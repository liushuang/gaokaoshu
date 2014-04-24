package com.gaokaoshu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liushuang.ls on 14-4-24.
 */
@Entity
@Table(name = "hot_type", schema = "", catalog = "gaokao_db")
public class HotTypeEntity {
    private int id;
    private Integer typeLevel;
    private Integer typeId;
    private String imgUrl;
    private String desc;
    private Timestamp createDatetime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_level")
    public Integer getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }

    @Basic
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "create_datetime")
    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotTypeEntity that = (HotTypeEntity) o;

        if (id != that.id) return false;
        if (createDatetime != null ? !createDatetime.equals(that.createDatetime) : that.createDatetime != null)
            return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (imgUrl != null ? !imgUrl.equals(that.imgUrl) : that.imgUrl != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (typeLevel != null ? !typeLevel.equals(that.typeLevel) : that.typeLevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeLevel != null ? typeLevel.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
