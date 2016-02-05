package com.itechart.training.Dao;

import com.itechart.training.models.LectionGroup;
import com.itechart.training.models.LectionPK;
import com.itechart.training.models.LectionType;
import com.itechart.training.models.LossStudent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by zhenya on 04.02.16.
 */
@Repository
public class LectionDao {

    @PersistenceContext
    private EntityManager manager;

    public LossStudent findMissById(long id) {
        return manager.find(LossStudent.class, id);
    }

    public LectionType findLectionById(long id) {
        return manager.find(LectionType.class, id);
    }

    public LectionGroup findLectureById(LectionPK key) {
        return manager.find(LectionGroup.class, key);
    }

}
