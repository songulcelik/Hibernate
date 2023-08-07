package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {
    public static void main(String[] args) {

        //configure()ye isim belirtmedik. normalde girdigimiz dosya ismini arar.dosya ismi vermedigimizde default degeri okur
        //default olarak "hibernate.cfg.xml"yi okur. farkli isim verseydik parametreli configure()yi kullanmak zorundaydik
        Configuration configuration=new Configuration().configure().addAnnotatedClass(Student01.class);

        SessionFactory sf= configuration.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();

        //dbden data cekmek icin 3 yol
        //1.yol://1.tercihimiz bu olabilir syntax hatasi az. method uzerinden is goturuyor
        Student01 student1= session.get(Student01.class,1001);//select*from t_student01 where std_id_1001
        Student01 student2= session.get(Student01.class,1002);//select*from t_student01 where std_id_1001
        Student01 student3= session.get(Student01.class,1003);//select*from t_student01 where std_id_1001

        System.out.println("-------------");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);


        //2.yol:sql sorgusunu kendimiz yazarak
        System.out.println("---------SQL QUERY----------");

        String sql= "select*from t_student01";
        List<Object[]> resultList=session.createSQLQuery(sql).getResultList();
        for (Object[] objects:resultList){
            System.out.println(Arrays.toString(objects));
        }

        //3.yol:HQL:hibernate query language. java bilesenlerimizi kullanarak sorgu yazabiliriz
        System.out.println("--------------HQL QUERY----------");
        String hql="from Student01";
        List<Student01> studentList=session.createQuery(hql, Student01.class).getResultList();
        for (Student01 student: studentList){
            System.out.println(student);
        }


        //ismi Ahmet olan kaydi goruntuleyelim
        //SQL
        String sql2="select* from t_student01 where std_name='Ahmet'";//sonucun bir kayi dondureceginden eminsek
        Object[] studentAhmet= (Object[]) session.createSQLQuery(sql2).uniqueResult();
        //object tipini de referans olarak aliyor
        System.out.println(Arrays.toString(studentAhmet));

        //HQL
        String hql2="from Student01 where name='Ahmet'";
        Student01 student01= session.createQuery(hql2, Student01.class).uniqueResult();
        System.out.println(student01);

        //yukaridaki hql sorgusunda ALIAS kullanalim, ismi songul olanin sadece id ve name ini yazin
        String hql3="select s.id, s.name from Student01 s where s.name='Songul'";
        Object[] studentSongul= (Object[]) session.createQuery(hql3).uniqueResult();//geriye [id ve name] gelcek
        System.out.println(Arrays.toString(studentSongul));

        tx.commit();
        session.close();
        sf.close();



    }
}
