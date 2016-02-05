package com.itechart.training.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zhenya on 04.02.16.
 */
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATED")
    private Date created;

    @ManyToOne
    @JoinColumn(name = "CURATOR_ID")
    private Teacher curator;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", curator=" + curator +
                '}';
    }
}
