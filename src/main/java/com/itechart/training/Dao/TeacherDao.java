package com.itechart.training.dao;

import com.itechart.training.models.Group;
import com.itechart.training.models.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Teacher add(Teacher teacher){
        manager.persist(teacher);
        manager.refresh(teacher);
        return teacher;
    }
}
