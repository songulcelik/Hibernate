package com.tpe.hb04.bi_onetoone;

import com.tpe.hb03.uni_onetoone.Student03;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary04 {//owner of relation, iliski sahibi, fk kimdeyse

    @Id//buranin primary keyi bu
    private int id;
    private String  name;

    @OneToOne//icinde bulundugu entitiyde uzerine yazdigimiz sutuna 1e1 iliski kuracak.
    //studentin pksini kullanarak fk olusturcak
    //student tablosunun PK sütununu kullanrak Diary tablosunda FK sütunu oluşturur. Default:student_id
    @JoinColumn(name = "std_id", unique = true)
    private Student04 student;

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

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", student=" + student +
                '}';
    }
}


