package com.tpe.hb06.onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

      //id:101 olan kitabi gormek istersek
        Book06 book1=session.get(Book06.class,101);
        System.out.println(book1);
        //bu kitabin sahibi kim

        //book1.getStudent diyemiyorum  booktan ogrenciye iliski kurduk tek iliski
        //id:1001 olan ogrencinin kitaplarini gorek
        Student06 student= session.get(Student06.class,1001);
        System.out.println(student.getBookList());


        //name:"Suleyman" olan ogrencinin kitaplarini gorek

        //String hql="select from Student06 s inner join Book06 b on b.id=s.bookList.id";
        //bu sekil join yapamiyoruz
        String hql="select b.id, b.name from  Student06 s inner join s.bookList b where s.name='Suleyman'";
        List<Object[]> resultList=session.createQuery(hql).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));

        //ogrenciden kitaba kitaptan ogrenciye ulasmak icin

        tx.commit();
        session.close();
        sf.close();


    }
}
