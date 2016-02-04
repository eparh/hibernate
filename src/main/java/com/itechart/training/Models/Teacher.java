package com.itechart.training.models;

import javax.persistence.*;

/**
 * Created by zhenya on 04.02.16.
 */
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "INT(11)")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String FirstName;
    @Column(name = "LAST_NAME")
    private String Lastname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}
