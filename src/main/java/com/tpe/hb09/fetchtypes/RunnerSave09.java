package com.tpe.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {


        Student09 student1 = new Student09(1001,"Ali",70);
        Student09 student2 = new Student09(1002,"Veli",70);
        Student09 student3 = new Student09(1003,"Can",70);
        Student09 student4 = new Student09(1003,"Deniz",70);

        Book09 book1 = new Book09(101,"A Book");
        Book09 book2 = new Book09(102,"B Book");
        Book09 book3 = new Book09(103,"C Book");
        Book09 book4 = new Book09(104,"D Book");
        Book09 book5 = new Book09(105,"E Book");

        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);


        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();


        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);
        session.persist(book5);

        //studenti persist etmedik ama cascadeAll dedigim icin bookla iliskili olan studenta da aynis islemi yapti
        //studentlari persist yaptik. student4e kitap vermedigimiz icin onu tabloya kaydetmedi.
        //sadece iliskili olan studentlari kaydetti

        //cascadetype iliski sahibi olmayan tarafta kullanilirsa iki taraftan da set yapilmali


        tx.commit();
        session.close();
        sf.close();





    }
}
