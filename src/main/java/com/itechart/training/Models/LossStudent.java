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
    @Column(name = "LOSS_STUDENT_ID", columnDefinition = "INT(11)")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "LECTION_ID")
    private LectionType lection;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LectionType getLection() {
        return lection;
    }

    public void setLection(LectionType lection) {
        this.lection = lection;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LectionType getLectionGroup() {
        return lection;
    }

    public void setLectionGroup(LectionType lection) {
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
        return "LossStudent{" +
                "id=" + id +
                ", student=" + student +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                '}';
    }
}
