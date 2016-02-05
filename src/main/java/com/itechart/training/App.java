package com.itechart.training;

import com.itechart.training.Dao.GroupDao;
import com.itechart.training.Dao.LectionDao;
import com.itechart.training.Dao.StudentDao;
import com.itechart.training.Dao.TeacherDao;
import com.itechart.training.config.SpringConfig;
import com.itechart.training.models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args ) {
        long id = 1;

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        System.out.println("Select student with id="+ id + ":");
        StudentDao studentDao = context.getBean(StudentDao.class);
        System.out.println(studentDao.findById(id));

        System.out.println();

        System.out.println("Select omission with id="+id + ":");
        LectionDao lectionDao = context.getBean(LectionDao.class);
        System.out.println(lectionDao.findMissById(id));

        System.out.println();

        System.out.println("Select group with id="+id + ":");
        GroupDao dao = context.getBean(GroupDao.class);
        Group group = dao.findById(id);
        System.out.println(group);

        System.out.println();

        System.out.println("Select lecture type with id="+2 +":");
        LectionType lection = lectionDao.findLectionById(2);
        System.out.println(lection);

        System.out.println();

        System.out.println("Select teacher with id="+id +":");
        TeacherDao teacherDao = context.getBean(TeacherDao.class);
        Teacher teacher = teacherDao.findById(id);
        System.out.println(teacher);

        //Primary key
        LectionPK key = new LectionPK(lection, group, teacher);

        System.out.println();

        System.out.println("Select lecture with id="+ key +":");
        LectionGroup lecture = lectionDao.findLectureById(key);
        System.out.println(lecture);
    }
}
