package com.gaokaoshu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liushuang on 26/5/14.
 */
@Entity
@Table(name = "blog", schema = "", catalog = "gaokao_db")
public class BlogEntity {
    private int id;
    private String content;
    private Integer typeId;
    private Timestamp createDatetime;
    private Integer goodCount;
    private Integer middleCount;
    private Integer badCount;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "create_datetime")
    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Basic
    @Column(name = "good_count")
    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    @Basic
    @Column(name = "middle_count")
    public Integer getMiddleCount() {
        return middleCount;
    }

    public void setMiddleCount(Integer middleCount) {
        this.middleCount = middleCount;
    }

    @Basic
    @Column(name = "bad_count")
    public Integer getBadCount() {
        return badCount;
    }

    public void setBadCount(Integer badCount) {
        this.badCount = badCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntity that = (BlogEntity) o;

        if (id != that.id) return false;
        if (badCount != null ? !badCount.equals(that.badCount) : that.badCount != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createDatetime != null ? !createDatetime.equals(that.createDatetime) : that.createDatetime != null)
            return false;
        if (goodCount != null ? !goodCount.equals(that.goodCount) : that.goodCount != null) return false;
        if (middleCount != null ? !middleCount.equals(that.middleCount) : that.middleCount != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        result = 31 * result + (goodCount != null ? goodCount.hashCode() : 0);
        result = 31 * result + (middleCount != null ? middleCount.hashCode() : 0);
        result = 31 * result + (badCount != null ? badCount.hashCode() : 0);
        return result;
    }
}
