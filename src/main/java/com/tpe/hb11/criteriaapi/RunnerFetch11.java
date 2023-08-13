package com.tpe.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Random;

public class RunnerFetch11 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student11.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        /*
        C: session.persist()/save()(depracate)
        R:session.get(), hql, sql,
        U:
        D:session.delete(),hql, sql

         */

        //idsi 2 olan studentin ismini guncelleyelim

        Student11 student=session.get(Student11.class,2);
        student.setName("Updated "+ student.getName());
        //hibernatede bir objeyi bir kere persist etmissek bu obje artik persist oluyor takip edilen anlaminda.
        // session icind obje uzerinde degisiklik yaparsak  dbye yansiyor

        //session.update(student); dogrudan yansitmadigi durumlarda degisikligin yansimasi icin update methodunu kullanbiliriz


        //grade i 30dan kucuk olan ogrencilerin grade ini 50 olarak guncelleyelim

        //String hql="update Student11 s set s.grade=50 where s.grade<30";
        String hql="update Student11 s set s.grade=:newValue where s.grade<:oldValue";
        Query query= session.createQuery(hql);
        query.setParameter("newValue",50);
        query.setParameter("oldValue",30);
        int updatedRecord= query.executeUpdate();
        System.out.println("updatedRecord : " + updatedRecord);


        /*
        String hql = "UPDATE Student11 s SET s.grade=?1 WHERE s.grade<?2";
        Query query = session.createQuery(hql);
        query.setParameter(1, 50); // newValue
        query.setParameter(2, 30); // oldValue
         */

        tx.commit();
        session.close();
        sf.close();



    }
}
