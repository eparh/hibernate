package com.itechart.training;

import com.itechart.training.dao.GroupDao;
import com.itechart.training.dao.LectureDao;
import com.itechart.training.dao.StudentDao;
import com.itechart.training.dao.TeacherDao;
import com.itechart.training.config.SpringConfig;
import com.itechart.training.models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
        LectureDao lectureDao = context.getBean(LectureDao.class);
        System.out.println(lectureDao.findMissById(id));

        System.out.println();

        System.out.println("Select group with id="+id + ":");
        GroupDao groupDao = context.getBean(GroupDao.class);
        Group group = groupDao.findById(id);
        System.out.println(group);

        System.out.println();

        System.out.println("Select lecture type with id="+2 +":");
        LectionType lection = lectureDao.findLectureById(2);
        System.out.println(lection);

        System.out.println();

        System.out.println("Select teacher with id="+id +":");
        TeacherDao teacherDao = context.getBean(TeacherDao.class);
        Teacher teacher = teacherDao.findById(id);
        System.out.println(teacher);

        //Primary key

        System.out.println();

        System.out.println("Select all lectures:");
        List<LectureGroup> lectureGroups = lectureDao.findAllLectures();
        for(LectureGroup lectureGroup: lectureGroups) {
            System.out.println(lectureGroup);
        }
        System.out.println();

        System.out.println("Select students from group:");
        List<Student> studentList = groupDao.getStudents(group);
        for(Student student: studentList) {
            System.out.println(student);
        }

        System.out.println();

        System.out.println("Select lectures by teacher:");
        List<LectionType> lectionTypes = lectureDao.findLecturesByTeacher(teacher);
        for(LectionType lectionType: lectionTypes) {
            System.out.println(lectionType);
        }

        System.out.println();

        System.out.println("Select groups by teacher:");
        List<Group> groupList = groupDao.findGroupsByTeacher(teacher);
        for(Group teacherGroup: groupList) {
            System.out.println(teacherGroup);
        }

        System.out.println();

        System.out.println("Select misses by group and lecture:");
        List<Student> misses = studentDao.getMisses(lection,group);
        for(Student student: misses) {
            System.out.println(student);
        }


        System.out.println();

        System.out.println("Select students which don't belong group:");
        List<Student>  students = studentDao.getAnotherStudent(group);
        for(Student student: students) {
            System.out.println(student);
        }
    }
}
