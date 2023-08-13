package com.tpe.hb11.criteriaapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student11 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//Best INteger. not null demezsek ve deger girmezsek null olarak girer. int deseydik ve dger girmeseydik defoult 0 girerdi

    private String name;

    private Integer grade;

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}



