package com.tpe.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RunnerFetch11criteria {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student11.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //CRITERIA APİ

        //hql de sql de string bazli sorgular. bu nedenle hataya acik
        //hibernatede sorgulari java kodlari kullananrk yapmamizi saglayan criteria api gelistirmis
        //criteria api:java kodlarini kullanarak programatik bir sorgu olusturabilmemizi saglar
        //methodlar uzerinden yapildigi icin hatalar azalir ve derleme aninda hata almamizi saglar
        //hibernate criteria api depracate oldu JPA criteria api gelistirildi
        //Read:CriteriaQuery(select). CriteriaQuery icin getCriteriaBuilder() lazim
        //Update:CriteriaUpdate
        //Delete:CriteriaDelete


        //select*from student11 icin
        CriteriaBuilder cb =session.getCriteriaBuilder();//cb ile CriteriaQuery oluşturmak için ve
        //cb ın metodlarını kullanabilmek için

        CriteriaQuery<Student11> criteriaQuery=cb.createQuery(Student11.class);//geriye doncek kayitlarimin data tipini yazdim :Student11.class
        Root<Student11> root= criteriaQuery.from(Student11.class);//memba. sorgularim surdan yapilcak diyorum

        //1.orn: Student11den tum kayitlari gorelim
//        criteriaQuery.select(root);//select*from student11
//
//        List<Student11> resultList=session.createQuery(criteriaQuery).getResultList();
//        resultList.forEach(System.out::println);

        //2.orn: student ismi "Student 6" olan ogrenci bilgileri
        criteriaQuery.select(root).
                where(cb.equal(root.get("name"),"Student 6"));

        List<Student11> resultList2= session.createQuery(criteriaQuery).getResultList();
        resultList2.forEach(System.out::println);

        //!!!  3.Örnek, grade değeri 80 den büyük olan öğrenci bilgilerini getirelim
        criteriaQuery.select(root).
                where(cb.greaterThan(root.get("grade"),80));
        List<Student11> resultList3= session.createQuery(criteriaQuery).getResultList();
        resultList3.forEach(System.out::println);

        //!!! 4.Örnek grade değeri 95 den küçük olan dataları getirelim
        criteriaQuery.select(root).
                where(cb.lessThan(root.get("grade"),95));
        List<Student11> resultList4= session.createQuery(criteriaQuery).getResultList();
        resultList4.forEach(System.out::println);

        // !!! 5. örnek : id si 1 veya grade değeri i 90 dan büyük olan kayıtları bulalım

        Predicate predicate1=cb.equal(root.get("id"),1);
        Predicate predicate2=cb.greaterThan(root.get("grade"),90);
       // Predicate predicateOr=cb.or(predicate1,predicate2);
        criteriaQuery.select(root).
                where(cb.or(predicate1,predicate2));

//        criteriaQuery.select(root).
//                where(predicateOr);

        //ismi Student 1 olan kaydı silelim.(CriteriaDelete ve roota ihtiyav var)
        //ismi Student 3 olan kaydın sadece name ve grade bilgilerini görelim.(CriteriaQuery olusturcaz ama generic tip ne olmali )CriteriaQuery<Object[]>

        //ismi Student 1 olan kaydı silelim.(CriteriaDelete)
        CriteriaDelete<Student11> criteriaDelete =cb.createCriteriaDelete(Student11.class);
        Root<Student11> rootDelete=criteriaDelete.from(Student11.class);
        criteriaDelete.where(cb.equal(rootDelete.get("name"),"Student 1"));
        System.out.println(session.createQuery(criteriaDelete).executeUpdate());
        //ismi Student 3 olan kaydın sadece name ve grade bilgilerini görelim.(CriteriaQuery<Object[]>)
        CriteriaQuery<Object[]> criteriaQuery2=cb.createQuery(Object[].class);
        Root<Student11> root2=criteriaQuery2.from(Student11.class);
        criteriaQuery2.select(cb.array(root2.get("name"),root2.get("grade"))).
                where(cb.equal(root2.get("name"),"Student 3"));
        session.createQuery(criteriaQuery2).getResultList().
                forEach(t-> System.out.println(Arrays.toString(t)));




        tx.commit();
        session.close();
        sf.close();



    }
}
