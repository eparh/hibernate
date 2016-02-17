package com.itechart.training.dao;

import com.itechart.training.models.Group;
import com.itechart.training.models.LectionType;
import com.itechart.training.models.Student;
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
public class StudentDao {
    @PersistenceContext
    private EntityManager manager;

    public Student findById(long id) {
        return manager.find(Student.class, id);
    }

    @Transactional
    public Student add(Student student){
        manager.persist(student);
        manager.refresh(student);
        return student;
    }

    public List<Student> getMisses(LectionType lecture, Group group) {
        TypedQuery<Student> query = manager.createQuery("SELECT DISTINCT s FROM LossStudent ls Join ls.student s WHERE" +
                        " ls.lecturePK.id.lectionType = :lecture AND ls.lecturePK.id.group = :group",
                Student.class);
        query.setParameter("lecture",lecture);
        query.setParameter("group",group);
        return query.getResultList();
    }

    public List<Student> getAnotherStudent(Group group) {
        TypedQuery<Student> query = manager.createQuery("SELECT s FROM Student s WHERE s.group <> :graup",
                Student.class);
        query.setParameter("graup",group);
        return query.getResultList();
    }
}
