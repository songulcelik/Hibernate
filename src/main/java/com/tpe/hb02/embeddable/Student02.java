package com.tpe.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id//entity annotasyonu kullanıldığında kullanımı zorunludur, PK sütununun belirlenmesini sağlar
    private int id;

    @Column(name = "std_name",length = 100,nullable = false,unique = true)//opsiyonel
    private String name;

    private int grade;
    //street
    //city
    //zipcode
    //country
    //adresle alakali fieldlar oldugu icin adresle alaali class olusturalim

    @Embedded//gomulu. opsiyonel. bunu yazmasak da olur. daha okunabilir olur kullandigimizda
    private Address address;
    //street,city,country,zipcode sutunu olacak




    //getter-setter
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
