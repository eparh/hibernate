package com.itechart.training;

import com.itechart.training.Dao.GroupDao;
import com.itechart.training.Dao.LectionMissDao;
import com.itechart.training.Dao.PlainDao;
import com.itechart.training.Dao.StudentDao;
import com.itechart.training.config.SpringConfig;
import com.itechart.training.models.Group;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        System.out.println(studentDao.findById(1));
        System.out.println( "Hello World!" );
        LectionMissDao lectionMissDao = context.getBean(LectionMissDao.class);
        System.out.println(lectionMissDao.findById(1));
        GroupDao dao = context.getBean(GroupDao.class);
        System.out.println(dao.findById(1));
    }
}
