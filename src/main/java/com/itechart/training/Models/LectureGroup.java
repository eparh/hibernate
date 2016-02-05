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

    @Column(name = "DATE")
    private Date date;

    public LecturePK getId() {
        return id;
    }

    public void setId(LecturePK id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LectureGroup{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
