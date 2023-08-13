package com.tpe.hb09.fetchtypes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book09 {//iliski sahibim book.diger tarafta mapped by kullandik
    @Id
    private int id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)//All tum seceneklerin heisini yap
    //cascade kullanildigi yerde, book objede persist ettigimizde nesnenin ilskili oldg student varsa onuda persist ediyor
    //silersem siliyor, update yaparsam update yapiyor
    private  Student09 student;//manytoone fetchtype eagerdir.

    public Book09(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book09() {
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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
