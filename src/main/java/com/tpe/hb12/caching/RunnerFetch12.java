package com.tpe.hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/*
1)  First Level Cache --->
            *nesne için kullanılır
            * defaultta açık geliyor , kapatma durumu yok
            * Aynı session içinde kayıt alır
            * session kapanınca içindekiler silinir

2) Second Level Cache --->
            *nesne için kullanılır
            * Defaultta kapalıdır
            * Session factory seviyesinde cacheleme yapar, yani farklı
                    sessionlar arasında data kullanılabiliyor
            * hibernate.cfg.xml den active edilebilir
            *aynı data aynı sessionda first level cacheden gelir,
             aynı data farklı sessionda second level cacheden gelir.


3) Query Cache
            * Query ler için kullanılıyor
            * hibernate.cfg.xml den active edilebilir
            * first/second level ile birlikte kullanılabilir.
 */
public class RunnerFetch12 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student12.class);//yerine xml de mapping


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

//        System.out.println("ilk get islemi ile id:1 olan studenti getirme");
//        Student12 student1= session.get(Student12.class,1);
//        System.out.println(student1);

        //session.clear();//cache i temizler


//        System.out.println("ayni sessionda ikinci kez get islemi ile id:1 olan studenti getirme");
//        Student12 student2= session.get(Student12.class,1);
//        System.out.println(student2);

        //DB de bir kez daha sorgu yapıp veriyi getirmesi beklenir..ANCAK
        //ikinci kez DB e gitmedi,  first level cache a atıldı, cachedan getirildi



        //QueryCache

        //query cache i kullanmak için configde ayarları yaptık
        //querynin sonucunun cache e yazılması/okunması için setCacheable ı true yapmalıyız

        Query query =session.createQuery("from Student12").setCacheable(true);//setle bu sorgumun sonuclar cacheye yazilsin veya bu sorgunun sonuclar cacheden okunsun demis oluyoruz
        query.getResultList();

        Query query2=session.createQuery("from Student12");
        query2.getResultList();


        tx.commit();
        session.close();

        //secondu actigimiz icin dbye tekrar gitmedi.
        Session session2= sf.openSession();
        Transaction tx2= session2.beginTransaction();
//
//        System.out.println("Farklı sessionda get işlemi ile id:1 olan student getirme");
//        Student12 student3=session2.get(Student12.class,1);
//        System.out.println(student3);


        Query query3=session2.createQuery("from Student12");
        query3.getResultList();
//second level cache activese DB ye gitmez

        tx2.commit();
        session2.close();

        sf.close();

        //SONUÇ:First Level Cache:
        //      aynı sessionda aynı objeyi fetch etmek istediğimizde
        //      bir kere DB ye başvurur, daha sonra cacheden getirir.
        // session kapatilir veya clear() methodu cagrilirisa cache temizlenir
        //dolayisiyla ayni obje icin tekrar dbye basvurulur



    }
}
