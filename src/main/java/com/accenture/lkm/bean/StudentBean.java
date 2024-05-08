package com.accenture.lkm.bean;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentBean {

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

    public StudentBean() {
    }

    public StudentBean(String studentName, int age, String dept, Date registrationDate, String address) {
        this.studentName = studentName;
        this.age = age;
        this.dept = dept;
        this.registrationDate = registrationDate;
        this.address = address;
    }

    public StudentBean(int studentId, String studentName, int age, String dept, Date registrationDate, String address) {
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
