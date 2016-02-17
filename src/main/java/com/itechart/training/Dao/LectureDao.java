package com.itechart.training.dao;

import com.itechart.training.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<LectureGroup> findAllLectures() {
        TypedQuery<LectureGroup> query = manager.createQuery("SELECT lg FROM LectureGroup lg", LectureGroup.class);
        return query.getResultList();
    }

    public List<LectionType> findLecturesByTeacher(Teacher teacher) {
        TypedQuery<LectionType> query = manager.createQuery("SELECT l FROM LectureGroup lg Join lg.id.lectionType l WHERE" +
                " lg.teacher =:teacher",
                LectionType.class);
        query.setParameter("teacher",teacher);
        return query.getResultList();
    }

    @Transactional
    public LectionType addType(LectionType type){
        manager.persist(type);
        manager.refresh(type);
        return type;
    }

    @Transactional
    public void add(LectureGroup lecture){
        manager.persist(lecture);
    }

    @Transactional
    public LossStudent addMiss(LossStudent lossStudent){
        manager.persist(lossStudent);
       // manager.refresh(lossStudent);
        return lossStudent;
    }
}
