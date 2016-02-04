package com.itechart.training.Dao;

import com.itechart.training.models.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by zhenya on 04.02.16.
 */
@Repository
public class StudentDao {

    @PersistenceContext
    private EntityManager manager;

    public Student findById(long id) {
        return manager.find(Student.class, id);
    }
}
