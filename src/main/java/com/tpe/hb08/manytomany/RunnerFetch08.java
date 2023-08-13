package com.tpe.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Course08.class);

        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        Student08 student= session.get(Student08.class,1001);//getle studentin tum objeleri geliyor. ama simdi sadece name grade id gelmis
        System.out.println(student.getCourseList());//bunu diyince course listesini getirmis oldu

        Course08 course= session.get(Course08.class,101);
        course.getStudentList();//idleri 1001,1002,1003 olan ogrenciler geldi

        //onetoone manytoone gibi iliskilerde get methodu icindeki iliskili tum objeleri getiriyordu. ama burada sadece studantla ilgili bilgiler gelldi
        //courselistesi icin ayri bir sorgu yapip getirdi


        tx.commit();
        session.close();
        sf.close();

    }
}
