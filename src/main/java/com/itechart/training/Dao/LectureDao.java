package com.itechart.training.Dao;

import com.itechart.training.models.LectureGroup;
import com.itechart.training.models.LecturePK;
import com.itechart.training.models.LectionType;
import com.itechart.training.models.LossStudent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by zhenya on 04.02.16.
 */
@Repository
public class LectureDao {

    @PersistenceContext
    private EntityManager manager;

    public LossStudent findMissById(long id) {
        return manager.find(LossStudent.class, id);
    }

    public LectionType findLectureById(long id) {
        return manager.find(LectionType.class, id);
    }

    public LectureGroup findCourseById(LecturePK key) {
        return manager.find(LectureGroup.class, key);
    }

}
