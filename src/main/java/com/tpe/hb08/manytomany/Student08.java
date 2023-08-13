package com.tpe.hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "t_student08")
public class Student08 {//many
    @Id
    private int id;
    private String name;
    private int grade;
    @ManyToMany
    @JoinTable(name = "student08_course08",//3.tablomuzun ismi, iliski tablosuna kendimiz isim verdik defoultuda bu sekilde.
            joinColumns = {@JoinColumn(name = "std_id")},//JOİNDE birinci sutun. studenttan gelen column
            inverseJoinColumns = {@JoinColumn(name = "course_id")})//joinde ikinci column. iliskilendirilmis clastan gelen sutunun ismi
    //jointable kullanimi opsiyonel
    private List<Course08> courseList=new ArrayList<>();//MANY
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

    public List<Course08> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course08> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Student08() {
    }

    public Student08(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
