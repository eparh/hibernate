package com.itechart.training.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhenya on 04.02.16.
 */
@Entity
@Table(name = "group_lection")
public class LectureGroup {
    @EmbeddedId
    private LecturePK id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    public LectureGroup(LecturePK id, Teacher teacher) {
        this.id = id;
        this.teacher = teacher;
    }

    public LectureGroup() {
    }

    public LecturePK getId() {
        return id;
    }

    public void setId(LecturePK id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "LectureGroup{" +
                "id=" + id + '}';
    }
}
