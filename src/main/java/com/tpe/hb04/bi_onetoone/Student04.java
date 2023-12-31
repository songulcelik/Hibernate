package com.tpe.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_student04")
public class Student04 {


    @Id//entity annotasyonu kullanıldığında kullanımı zorunludur, PK sütununun belirlenmesini sağlar
    private int id;

    @Column(name = "std_name",length = 100,nullable = false,unique = true)//opsiyonel
    private String name;

    private int grade;
    @OneToOne(mappedBy = "student")//iki yonlu iliski olmus oluyor. fk sutunu olusturyor. ama burada gerek yok
                                    //mappedBy= sadece diary tablosunda fk olusturur. aama studentten diarye ulasabiliriz
                                   //iliski sahibi olacak digeri demis oluyoruz
                                    //mappedby kullanilmazsa her ikş tabloda da fk olu ve buna gerek yok
    private Diary04 diary;

    //pmsiz cons

    public Student04() {
    }


    //getter-setter


    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", diary=" + diary +
                '}';
    }
}
