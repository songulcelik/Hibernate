package com.tpe.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Course08.class);

        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        Student08 student1 = new Student08(1001,"Ali",50);
        Student08 student2 = new Student08(1002,"Veli",60);
        Student08 student3 = new Student08(1003,"Can",70);

        Course08 course1 = new Course08(101,"Java Course");
        Course08 course2 = new Course08(102,"Css Course");
        //set etme iliski sahibinden yapilir. iliski sahibi mapped by olmayan. yani student

        student1.getCourseList().add(course1);
        student1.getCourseList().add(course2);

        student2.getCourseList().add(course1);
        student2.getCourseList().add(course2);

        student3.getCourseList().add(course1);

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
        session.persist(course1);
        session.persist(course2);

        System.out.println(student1.getCourseList());//bu gelir
        System.out.println(course1.getStudentList());//buradan gelmez [] bos gelir


        tx.commit();
        session.close();
        sf.close();

    }
}
