package com.itechart.training;

import com.itechart.training.Dao.PlainDao;
import com.itechart.training.Dao.StudentDao;
import com.itechart.training.config.SpringConfig;
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
        PlainDao dao = context.getBean(PlainDao.class);
        dao.test();
    }
}
