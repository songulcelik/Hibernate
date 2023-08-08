package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {
        Student01 student1=new Student01();
        student1.setId(1001);
        student1.setName("Songul");
        student1.setGrade(98);
        student1.setAge(32);

        Student01 student2= new Student01();
        student2.setId(1002);
        student2.setName("Ahmet");
        student2.setGrade(99);
        student2.setAge(33);

        Student01 student3=new Student01();
        student3.setId(1003);
        student3.setName("Hasan");
        student3.setGrade(95);
        student3.setAge(30);

        //hibernate.cfg.xml dosyasindaki bilgileri ve Student01 classindaki anatosyanlara gore konfigurasyon yapilit.
        //configure() ve addAnotationla() kullanarak yapilandirma ayarlarini gerceklestir diyoruz
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        //addAnnotatedClass ile entity classimizi hibernate e gosteriyoruz

        //tum uygulamada sadece bir tane sf olusturulur. fakat farkli islemler icin birden fazla session acilabilir
        SessionFactory sf= configuration.buildSessionFactory();//db ile ilgili islemlerin yonetimini saglar
        Session session= sf.openSession();//openSession() db deki herbir oturumu temsil diyor
        //session dbde crud opr icin ve sorgulari calistirmak icin methodlar icerir

        //hibernate de outo-commit:false dur.islem icin transaction baslatmak lazim
        Transaction tx= session.beginTransaction();//dbde bir transaction baslatir

        //INSERT INTO .. yerine
       // session.persist(student1);//kalici hale getir demek
       // session.persist(student2);
        session.persist(student3);


        tx.commit();//transactionu kalici hale getirmek icin
        session.close();
        sf.close();//kaynak kullaniminin sonlandirilmasi icin





    }
}
