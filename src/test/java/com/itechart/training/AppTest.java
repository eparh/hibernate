package com.itechart.training;

import com.itechart.training.config.SpringConfig;
import com.itechart.training.dao.GroupDao;
import com.itechart.training.dao.LectureDao;
import com.itechart.training.dao.StudentDao;
import com.itechart.training.dao.TeacherDao;
import com.itechart.training.models.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})
public class AppTest extends TestCase
{
    @Autowired
    private GroupDao groupDao;

    @Autowired
    private LectureDao lectureDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Before
    public void setup(){
        Teacher teacher = new Teacher("Ivan","Petrov");
        teacher = teacherDao.add(teacher);
        Teacher anotherTeacher = new Teacher("Vadim","Pianov");
        anotherTeacher = teacherDao.add(anotherTeacher);

        //Groups
        Group firstGroup = new Group("PM", new Date(), teacher);
        firstGroup = groupDao.add(firstGroup);
        Group secondGroup = new Group("TP", new Date(), teacher);
        secondGroup = groupDao.add(secondGroup);

        //Students
        Student studentOne = new Student("Petr","Petrov",new Date(),firstGroup);
        studentOne = studentDao.add(studentOne);
        Student studentTwo = new Student("Igor","Lisin",new Date(),firstGroup);
        studentTwo = studentDao.add(studentTwo);
        Student studentThree = new Student("Andrei","Malov",new Date(),secondGroup);
        studentThree = studentDao.add(studentThree);

        //Types of Lecture
        LectionType typeOne = new LectionType("Proga");
        typeOne = lectureDao.addType(typeOne);
        LectionType typeTwo = new LectionType("Matan");
        typeTwo = lectureDao.addType(typeTwo);
        LectionType typeThree = new LectionType("GA");
        typeThree = lectureDao.addType(typeThree);

        System.out.println(typeThree);

        //Lectures
        LectureGroup lectureOne = new LectureGroup(new LecturePK(typeOne, new Date(), firstGroup), teacher);
        lectureDao.add(lectureOne);
        LectureGroup lectureTwo = new LectureGroup(new LecturePK(typeTwo, new Date(), secondGroup), anotherTeacher);
        lectureDao.add(lectureTwo);
        LectureGroup lectureThree = new LectureGroup(new LecturePK(typeThree, new Date(), firstGroup), anotherTeacher);
        lectureDao.add(lectureThree);


        //Misses
        LossStudent lossStudent = new LossStudent(studentOne,lectureOne,"illness");
        lectureDao.addMiss(lossStudent);
    }

    @org.junit.Test
    public void  testFindById() {
        assertNotNull(groupDao.findById(1));
    }
}
