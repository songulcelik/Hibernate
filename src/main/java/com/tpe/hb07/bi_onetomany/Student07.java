package com.tpe.hb07.bi_onetomany;

import com.tpe.hb06.onetomany_uni.Book06;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student07")
public class Student07 {//one taraf--parent
    @Id
    private int id;
    private String name;
    private int grade;
    @OneToMany(mappedBy = "student", /*cascade = CascadeType.REMOVE*/ orphanRemoval = true)//burada fk olusmayacagi icn jointable olusturur
    //mapped by ile diyoruz booklistteki degerleri studenta ekle
    //iliski kuruyorum ama iliski burdan yonetilmicek
    //cascade = CascadeType.REMOVE ilk kitaplari siliyor sonra studenti siliyor

    //orphanRemoval = true sadece onetomant ye ozel.parenttaki veriyi siliyor. ilk iliskili olan childlari siliyor sonra
    //parenti siliyor

    private List<Book07> bookList= new ArrayList<>();//child. parenti silmek icin childa cascede
    public Student07(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student07() {
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

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
