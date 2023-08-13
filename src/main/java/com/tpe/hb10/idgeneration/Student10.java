package com.tpe.hb10.idgeneration;

import javax.persistence.*;

@Entity
@Table(name = "t_student10")
public class Student10 {
    //idyi otomatik olusturmak istersek

    /*

    AUTO:Kullanılan DB ye göre stratejiyi belirler
       Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
            başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
       MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
            içlerindeki en basitidir)

     IDENTITY:1 den başlar 1er artırarak id leri generate eder.
     SEQUENCE:id set oluşturur,başlangıç değeri verebiliriz,HIZLIDIR
     TABLE:id üretmek için tablo oluşturur,EN YAVAŞ, bu sebeple pek tercih edilmez
     */

    @Id
    @GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq",// genratedValueda generator ozelligini verebilmek icin
                       initialValue = 1000,//baslangic degeri.default:1
                        allocationSize = 5,//id sette hazirda bekleyecek id sayisi.default:1
                        sequenceName = "std_seq")//dbde tanimlanan sequenca isim verdik
    private int id;
    private String name;
    private int grade;

    public Student10(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student10() {
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


}
