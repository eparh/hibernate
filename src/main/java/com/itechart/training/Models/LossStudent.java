package com.itechart.training.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhenya on 04.02.16.
 */
@Entity
@Table(name = "loss_student")
public class LossStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOSS_STUDENT_ID", columnDefinition = "INT(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumns( {
            @JoinColumn(name = "LECTION_ID", referencedColumnName = "LECTION_ID"),
            @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID"),
            @JoinColumn(name = "DATE", referencedColumnName = "DATE")
    })
    private LectureGroup lecturePK;

    @Column(name = "REASON")
    private String reason;

    public LossStudent(Student student, LectureGroup lecturePK, String reason) {
        this.student = student;
        this.lecturePK = lecturePK;
        this.reason = reason;
    }

    public LossStudent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LectureGroup getLecturePK() {
        return lecturePK;
    }

    public void setLecturePK(LectureGroup lecturePK) {
        this.lecturePK = lecturePK;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "LossStudent{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                '}';
    }
}
