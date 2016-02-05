package com.itechart.training.Dao;

import com.itechart.training.models.LossStudent;
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

    public LossStudent findById(long id) {
        return manager.find(LossStudent.class, id);
    }
}
