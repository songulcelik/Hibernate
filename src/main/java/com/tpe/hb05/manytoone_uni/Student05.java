package com.tpe.hb05.manytoone_uni;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {//many olan taraf. fk manyde olusur

    @Id
    private int id;

    private String name;

    private int grade;

    private LocalDateTime createOn;

    @PrePersist//bu classin objesi persisit edilmeden once(dbye eklenmeden) bu methodu cagir
    public void prePersist(){//objeler persist edilmeden hemen once, dbye kaydedildigi zaman kullanilsin istiyorum
        this.createOn=LocalDateTime.now();
    }

    @ManyToOne//student tablosunda fk olusturur ve default ismi:university_id
    @JoinColumn(name = "uni_id")
    private University university; //one

    //parametreli cons


    public Student05(int id, String name, int grade, University university) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.university = university;
    }

    //parametresiz cons
    public Student05() {
    }

    //getter setter
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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
