package com.itechart.training.Dao;

import com.itechart.training.models.LectionMiss;
import com.itechart.training.models.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by zhenya on 04.02.16.
 */
@Repository
public class LectionMissDao {

    @PersistenceContext
    private EntityManager manager;

    public LectionMiss findById(long id) {
        return manager.find(LectionMiss.class, id);
    }
}
