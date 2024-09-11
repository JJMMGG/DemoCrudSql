package org.example.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

//1
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, columnDefinition="VARCHAR(255)")
    private String name;
    @Column(nullable = false, columnDefinition="VARCHAR(255)")
    private String email;
    @Column(nullable = false, columnDefinition="DATE")
    private LocalDate dob;
    //@Column(nullable = false, columnDefinition="TINYINT")
    @Transient
    private Integer age;

    protected Student() {
        // no-args constructor required by JPA spec
        // this one is protected since it should not be used directly
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
