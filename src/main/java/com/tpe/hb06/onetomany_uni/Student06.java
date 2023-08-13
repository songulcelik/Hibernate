package com.tpe.hb06.onetomany_uni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {//one taraf
    @Id
    private int id;
    private String name;
    private int grade;
    @OneToMany//fk sutununu biz bookda olusturmak istiyoruz. normalde anotasyonu kullandigimiz yerde olusuyordu
                //fk ekleyemeyecegi icin 3.tablo olusturur buna da jointable deniyır(std_id-->book_id)
   @JoinColumn(name = "student_id")//kullanildiginda fk sutunu diger (book)da olusturur aksi halde yukaridaki join table olusur

    //many tarafina fk kuramaz. bu nedenle ucuncu tablo olusturur. bu tabloyu kurmadan da iliskiyi yonetebiliriz
    //onemli olan fknin one tarafinda degil many tarafinda olmasi.joincolumn kullanirsam 3.tablo olusmaz
    //bookda bir fk ekler dbde book tarafindan takip eder. ama java uygulamasinda studenttan set islemleri yapabiliriz
    private List<Book06> bookList= new ArrayList<>();//best practice set kullanmak. uniq olursa. listte tekrarli ekleyebiliriz
                                                        //many
    public Student06(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    public Student06() {
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

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book06> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
