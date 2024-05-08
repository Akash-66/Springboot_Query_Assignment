package com.accenture.lkm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    @NotEmpty(message = "Student name should not be empty")
    private String studentName;
    @Range(min = 18,max = 45,message = "Age should not be less than 18 and more than 45")
    private int age;
    @Size(min = 3,max = 20,message = "Department string size should be between 3 to 20")
    private String dept;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;
    private String address;

    public StudentEntity() {
    }

    public StudentEntity(String studentName, int age, String dept, Date registrationDate, String address) {
        this.studentName = studentName;
        this.age = age;
        this.dept = dept;
        this.registrationDate = registrationDate;
        this.address = address;
    }

    public StudentEntity(int studentId, String studentName, int age, String dept, Date registrationDate, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.dept = dept;
        this.registrationDate = registrationDate;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", registrationDate=" + registrationDate +
                ", address='" + address + '\'' +
                '}';
    }
}
