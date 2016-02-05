package com.itechart.training.models;

import javax.persistence.*;
import java.util.Date;
import java.util.logging.StreamHandler;

/**
 * Created by zhenya on 04.02.16.
 */
@Entity
@Table(name = "loss_student")
public class LectionMiss {

    @Id
    @Column(name = "LOSS_STUDENT_ID", columnDefinition = "INT(11)")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "LECTION_ID")
    private Lection lection;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "REASON")
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lection getLection() {
        return lection;
    }

    public void setLection(Lection lection) {
        this.lection = lection;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "LectionMiss{" +
                "id=" + id +
                ", student=" + student +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                '}';
    }
}
