package com.tpe.hb12.caching;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
//student12 entitimin cachelenebilir bir entiti oldugunu belirtmis oluyoruz
//firs level cache defaultta acik, 2.level cache alinabilir demek icin @Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)//okuma ve cekmede 2.cacheyi acik hale getiriyoruz
public class Student12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer grade;

    //getter-setter


    public Integer getId() {
        return id;
    }


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
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
