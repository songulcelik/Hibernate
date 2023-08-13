package com.tpe.hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course08 {//many
    @Id
    private int id;
    private String name;
    @ManyToMany(mappedBy = "courseList")///boyle birakirsak join table olusturur. ikisinde olusmamasi icin mapped by. kurs icindeki student listem coursliste mapplensin
    private List<Student08> studentList= new ArrayList<>();

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

    public List<Student08> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student08> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Course08(int id, String name) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
    }

    public Course08() {
    }
}
