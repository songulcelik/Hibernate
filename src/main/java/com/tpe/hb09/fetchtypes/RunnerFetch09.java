package com.tpe.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :

OneToMany       --> LAZY   ikinci kisim many ise lazy
ManyToMany      --> LAZY
OneToOne        --> EAGER  ikinci kisim one ise eager davraniyor defaultta boyle davranir
ManyToOne       --> EAGER
*/
public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        Student09 student= session.get(Student09.class,1001);//student, id,nameigrade bilgileri geldi
//        System.out.println(student.getBookList());//studentin kitap bilgilerini getirdi
//
//
        Book09 book= session.get(Book09.class,101);//book+student bilgileri geldi
//        System.out.println(book.getStudent());//zaten iliskili oldg studenti getiriyodu. studenta geti dedigimde dbye gitmedi zaten getirmistim diyor

        //duruma gore fetchtypi degistirebiliriz



        tx.commit();
        session.close();

        System.out.println(student.getBookList());//session kapali old icin booklari getirmez
                                                    //fetchtype lazy oldg icin sadece student getirir.sessinon kapali oldg icin booklari almaya gittiginde gelmez
        System.out.println(book.getStudent());//studenti getirir. eager oldugu icin hepsini yukarda getirmisti.
                                                // yukarda book.gette herseyi getirdigi icin session kapali olsa bile
                                                //elinde oldg icin getirir

        sf.close();

    }
}
