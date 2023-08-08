package com.tpe.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {//owner of relation, iliski sahibi, fk kimdeyse

    @Id//buranin primary keyi bu
    private int id;
    private String  name;

    @OneToOne//icinde bulundugu entitiyde uzerine yazdigimiz sutuna 1e1 iliski kuracak.
    //studentin pksini kullanarak fk olusturcak
    //student tablosunun PK sütununu kullanrak Diary tablosunda FK sütunu oluşturur. Default:student_id
    @JoinColumn(name = "std_id", unique = true)
    private Student03 student;

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}


