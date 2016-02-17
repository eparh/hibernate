package com.itechart.training.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhenya on 05.02.16.
 */
@Embeddable
public class LecturePK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "LECTION_ID")
    private LectionType lectionType;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    public LecturePK(LectionType lectionType, Date date, Group group) {
        this.lectionType = lectionType;
        this.date = date;
        this.group = group;
    }

    public LecturePK() {
    }

    public LectionType getLectionType() {
        return lectionType;
    }

    public void setLectionType(LectionType lectionType) {
        this.lectionType = lectionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "LecturePK{" +
                "lectionType=" + lectionType +
                ", date=" + date +
                ", group=" + group +
                '}';
    }
}
