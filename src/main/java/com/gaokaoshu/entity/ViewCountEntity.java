package com.gaokaoshu.entity;

import javax.persistence.*;

/**
 * Created by liushuang.ls on 14-3-26.
 */
@Entity
@Table(name = "view_count", schema = "", catalog = "gaokao_db")
public class ViewCountEntity {
    private int id;
    private Integer count;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewCountEntity that = (ViewCountEntity) o;

        if (id != that.id) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }
}
