package com.itechart.training.dao;

import com.itechart.training.models.Group;
import com.itechart.training.models.LectionType;
import com.itechart.training.models.Student;
import com.itechart.training.models.Teacher;
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
public class GroupDao {
    @PersistenceContext
    private EntityManager manager;

    public Group findById(long id) {
        return manager.find(Group.class, id);
    }

    @Transactional
    public Group add(Group group){
        manager.persist(group);
        manager.refresh(group);
        return group;
    }

    public List<Student> getStudents(Group group){
        TypedQuery<Student> query = manager.createQuery("Select s from Student s WHERE s.group = :graup", Student.class);
        query.setParameter("graup",group);
        return query.getResultList();
    }

    public List<Group> findGroupsByTeacher(Teacher teacher) {
        TypedQuery<Group> query = manager.createQuery("SELECT DISTINCT g FROM LectureGroup lg Join lg.id.group g WHERE" +
                        " lg.teacher =:teacher",
                Group.class);
        query.setParameter("teacher",teacher);
        return query.getResultList();
    }
}
