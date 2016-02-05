package com.itechart.training.models;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by zhenya on 05.02.16.
 */
@Embeddable
public class LectionPK  implements Serializable{
    @ManyToOne
    @JoinColumn(name = "LECTION_ID")
    private LectionType lectionType;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    public LectionType getLectionType() {
        return lectionType;
    }

    public LectionPK(LectionType lectionType, Group group, Teacher teacher) {
        this.lectionType = lectionType;
        this.group = group;
        this.teacher = teacher;
    }

    public void setLectionType(LectionType lectionType) {
        this.lectionType = lectionType;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "LectionPK{" +
                "lectionType=" + lectionType +
                ", teacher=" + teacher +
                ", group=" + group +
                '}';
    }
}
