package com.tpe.hb07.bi_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book07 {
    @Id
    private int id;
    private String name;

    @ManyToOne//mapped by yok burda sebebi ise kullanim mantik disi
    //@JoinColumn(name = "std_id") opsiyonel. kullanilmasa da diger classda mapped by old icin fk burada olusur
    private Student07 student;

    public Book07(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book07() {
    }

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
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

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
