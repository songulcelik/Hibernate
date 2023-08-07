package com.tpe.hb01.annotation;

import javax.persistence.*;

@Entity/*bu classtan olusturdugumuz objeleri kalici hale getirmek icin
         dbde bir tablo olusturulur--> Student01 tablo ismi
         */
@Table(name = "t_student01")//tabloya custom bir isim verdik. opsiyonel
//orm javadaki bilesenleri dbye mapler.
//HQL:Student01
//SQL:t_student01

public class Student01 {

    @Id//entity annatasyonu kullanildiginda kullanimi zorunludur, pk sutununun belirlenmesini saglar.
    // hangisi olsun istiyorsak o fieldin ustune yazilir
    @Column(name = "std_id")
    private int id;

    @Column(name = "std_name", length = 100, nullable = false, unique = true)//attribute.. opsiyonel. kullanmasak da olur. bazi ozellikler vermek istersek. isim degistirmek,
    private String name;

      private int grade;

    @Transient//bu fielda karsilik bir sutun olusmamis oluyor
    private int age;//bunun icin sutun olusturmak istemiyorum javada kullanicam bunun icin uzerine

    //BLOB:buyuk boyuttaki resim video ses buyuk text icin icin
//    @Lob//large object. buyuk boyutlu datalar icin sutun olusmasini saglar
//    private byte[] image;//byte arrayda tutariz



    //getter-setter
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }


}
