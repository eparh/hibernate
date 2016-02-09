package com.itechart.training.dao;

import com.itechart.training.models.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by zhenya on 05.02.16.
 */
@Repository
public class TeacherDao {
    @PersistenceContext
    private EntityManager manager;

    public Teacher findById(long id) {
        return manager.find(Teacher.class, id);
    }
}
