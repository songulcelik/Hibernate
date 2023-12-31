package com.tpe.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure().addAnnotatedClass(Student02.class);
        SessionFactory sf= configuration.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

        //idsi 1001 olan ogrenciyi gormek istersek
        Student02 student1= session.get(Student02.class,1001);
        System.out.println(student1);
        System.out.println(student1.getAddress());


        tx.commit();
        session.close();
        sf.close();
    }
}
