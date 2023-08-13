package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch007 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

//        //tüm studentları silebilir miyiz?EVET ama aşamalı olarak silebiliriz
//        //öncelikle tüm kitapları silelim
//        String hql="DELETE FROM Book07";
//        int numOfRecord=session.createQuery(hql).executeUpdate();
//        System.out.println("silinen kayıt sayısı : "+numOfRecord);
//
//        String hql2="DELETE FROM Student07";
//        int numOfRecord2=session.createQuery(hql2).executeUpdate();
//        System.out.println("silinen kayıt sayısı : "+numOfRecord2);
//
//        //name:C++ Book olan kitabı silelim.
//        String hql3="DELETE FROM Book07 b WHERE b.name='C++ Book'";
//        int numOfRecord3=session.createQuery(hql2).executeUpdate();
//        System.out.println("silinen kayıt sayısı : "+numOfRecord3);
//
//
//        //--------------------------------------------------------------------------------------
//
//        //kitabı olan bir öğrenciyi silmek istersek
//        //1-öğrencinin ilişkili olduğu kitapları silip sonra öğrenciyi silebiliriz.
//        //2-cascade = CascadeType.REMOVE/orphanRemoval
//
        //id:1001 olan studentı silelim.
//        Student07 student1=session.get(Student07.class,1001);
//        session.delete(student1);


        //orphanRemoval ın farkı:???
        //sadece onetomanye ozel
        //collectiondan bir eleman silinirse yada silmeye yakin olan null olarak set edilirse
        //orphanRemoval bu nesneyi tablodan da kaldirir

        Student07 student2=session.get(Student07.class,1002);
        student2.getBookList().remove(0);//103,104,105. 103 olani silmek istiyorum
        System.out.println(student2.getBookList());

        //orphanremoveda nesneyi silince nesneyi tablodan da kaldiriyor

        //musteri-siparis-->one to many . musteri siparisi iptal etti.siparis listesinden siparisi silicez
        //siparisi listeden sildigimde tablodan da silinsin isteyebilirim.bu durumda orphanReove kullanilabilir


        //tablodan direk delete islemi gercek uygulamalarda cok tercih edilmez. verinin statusunu degistiririz.
        //yanlis silme olursa geri alabilmek adina




        tx.commit();
        session.close();
        sf.close();


    }
}
