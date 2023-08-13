package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        Student07 student=session.get(Student07.class,1001);
        System.out.println(student.getBookList());
        System.out.println("---------------");

        Book07 book=session.get(Book07.class,101);
        System.out.println(book.getStudent());

        //PRACTICE
        //  SQL ile, kitabı olan öğrencilerin öğrenci ve kitap isimlerini listeleyelim
        //  aynı sorguyu HQL ile yazalım
        //  book ismi içinde "Java" geçen student kayıtlarını alalım ( HQL )

        System.out.println("sql");
        String hql1="SELECT s.name, b.name FROM t_student07 s INNER JOIN Book07 b ON b.student_id=s.id ";
        //String hql1="select s.name, b.name from t_student07 s inner join book07 b on s.id=b.student_id";
        List<Object[]> resultList1=session.createSQLQuery(hql1).getResultList();
        resultList1.forEach(t-> System.out.println(Arrays.toString(t)));



        //hql
        String hql="select s.name, b.name from Student07 s inner join s.bookList b ";
        List<Object[]> resultList=session.createQuery(hql).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));

        tx.commit();
        session.close();
        sf.close();


    }
}
