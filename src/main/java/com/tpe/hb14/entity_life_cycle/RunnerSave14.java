package com.tpe.hb14.entity_life_cycle;

import com.tpe.hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave14 {
    public static void main(String[] args) {

        Student14 student1= new Student14();//transient
        student1.setName("Jack");
        student1.setGrade(100);

        Student14 student2= new Student14();
        student2.setName("Harry");
        student2.setGrade(100);

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student14.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

//        session.persist(student1);//persisted or managed
//        student1.setName("Sherlock");//persist edip ismini degistirdim
//
//        //session icinde detach etmek istedigimde
//        //session.evict(student1);//bu objeyi detach eder sessionun takibinden cikarir dedgisiklikleri dbye yansitmaz
//        student1.setGrade(700);

        //detach edilmis objeyi tekrar sessiomun takibine baglamak icin
        //session.update(student1);
//---------------------------------------------------------

        session.persist(student1);
        session.persist(student2);
        //-------------------------------------------------------------
        tx.commit();
        session.close();


//        student1.setName("Ahmet");//sessionun yonetiminden cikti detach oluyor. tabloda karsiligi var ama uzerinde yapilanalar dbye yansitilmaz
//
//        Session session2=sf.openSession();
//        Transaction tx2= session2.beginTransaction();

//        session2.update(student1);//std detachti session2update ile persisted moda aldik
//        student1.setName("Mehmet");


//        tx2.commit();
//        session2.close();
        sf.close();

    }

}
