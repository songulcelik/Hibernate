package com.tpe.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//loadla get ayni islemi yapiyor peki farki ne
        /*
   get -> dönen objeye hemen ihtiyaç duyulursa get kullanılır.
       -> hemen db ye başvurur
       -> obje yoksa null döner
       -> id ile obje olduğuna emin değilsek get kullanılmalı


   load -> proxy(gölge) döner
        -> hemen db ye başvurmaz->ne zaman ihtiyaç duyulursa gerçek nesneyi döner
        -> obje yoksa not found exception fırlatır
        -> id ile obje olduğuna eminsek load kullanılmalı
        -> objeye reference olarak ihtiyaç duyulursa kullanılmalı
 */

//load hemen gitmiyor obje ile bise yapacagimiz zaman dbye gidiyor. ilk basta proxy obje getiriyor
//load methodu datalari fetch ederken lazy davraniyor.get methodu eagerly gibi davraniyor
//id ile objenin varl  igindan eminsek load kullanmaliyiz exeption almamak icin.
//objenin olduguna emin degilsek get methodu kullanmaliyiz

public class RunnerFetch13 {
    public static void main(String[] args) {



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student13.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //get
//        System.out.println("----------get baslangic");
//        Student13 student1= session.get(Student13.class,1);
//        System.out.println("--------get bitis");
//        System.out.println( "ıd:" + student1.getId());
//        System.out.println("name: "+ student1.getName());


        //load
//        System.out.println("++++++++++++++load metodu başlangıç");
//        Student13 student2=session.load(Student13.class,1);
//        System.out.println("++++++++++++++load metodu bitiş");//dbye gitmedi
//        System.out.println("Id: "+student2.getId());//yine gitmedi id 1 i getirdi
//        System.out.println("Name: "+ student2.getName());

        //olmayan id ile obje fetch edelim
//        Student13 student3=session.get(Student13.class,50);
//        //System.out.println(student3.getId());
//        if(student3!=null){
//            System.out.println("ID: "+student3.getId());
//            System.out.println("Name: "+student3.getName());
//        }

        //load ile
        Student13 student4=session.load(Student13.class,50);
        System.out.println("id: "+ student4.getId());//id:50 getirdi ama o obje yok. idyi kendimiz yazdiigmiz icin getirdi hayali
        System.out.println(student4.getName());//bu objeyi gercekten kullanmak istedigimde ObjectNotFoundException aldik

        tx.commit();
        session.close();
        sf.close();


    }

}
