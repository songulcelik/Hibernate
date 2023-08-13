package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //id:1001 olan student
         Student04 student=session.get(Student04.class,1001);
        System.out.println("Student1in diarysi: "+student.getDiary());
        //studentdan giarye ulasabiliyoruz

        //idsi 11 olan diart
        Diary04 diary= session.get(Diary04.class,11);
        System.out.println("1.dairynin sahibi "+ diary.getStudent());

        //bi_directional iliskide uygulamamizda kodlar ile herbir  objeden digerine ulasabilirz fakat
        //bi/uni directional iliskide dbdeki tablolar acisindan fark yok. fark java uygulamasinda cikyor

        // !!! Task 1: Diary ve Student tablolarında ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.

        //String hql="select s.name, d.name from Student04 s inner join Diary04 d on s.id=d.student.id";
        String hql="select s.name, d.name from Student04 s inner join Diary04 d on s.id=d.student";
        //hibernate bunu anliyor o nedenle s.id=d.student yapabiliriz
        List<Object[]> resultList =session.createQuery(hql).getResultList();
        resultList.
                forEach(t-> System.out.println(Arrays.toString(t)));
        System.out.println("-------------------------------------");

        // !!! Task 2: Student tablosunda tüm kayıtlar için
        //student name ve diary name fieldlarını getirelim.
        String hql2="select s.name, d.name from Student04 s left join Diary04 d on s.id=d.student";
        List<Object[]> resultList2= session.createQuery(hql2).getResultList();
        resultList2.forEach(t-> System.out.println(Arrays.toString(t)));
        System.out.println("-------------------------------");

        // !!! Task 3: tum Günlükler ve gunlugu olan studentlarin student name ve diary name fieldlarını getirelim.
        String hql3="select s.name, d.name from Student04 s right join Diary04 d on s.id=d.student";
        List<Object[]> resultList3= session.createQuery(hql3).getResultList();
        resultList3.forEach(t-> System.out.println(Arrays.toString(t)));

        // !!! Task 4:Diary ve Student tablosunda tüm kayıtlar için
        //student name ve diary name fieldlarını getirelim.
        String hql4="SELECT s.name, d.name FROM Student04 s FULL JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList4=session.createQuery(hql4).getResultList();
        resultList4.forEach(t-> System.out.println(Arrays.toString(t)));






        tx.commit();
        session.close();
        sf.close();

    }
}
