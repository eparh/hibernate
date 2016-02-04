package com.itechart.training.models;

import javax.persistence.*;

/**
 * Created by zhenya on 04.02.16.
 */
@Entity
@Table(name = "lection")
public class Lection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
