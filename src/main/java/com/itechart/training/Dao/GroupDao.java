package com.itechart.training.dao;

import com.itechart.training.models.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by zhenya on 04.02.16.
 */
@Repository
public class GroupDao {

    @PersistenceContext
    private EntityManager manager;

    public Group findById(long id) {
        return manager.find(Group.class, id);
    }

}
