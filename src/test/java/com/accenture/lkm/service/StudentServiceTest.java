package com.accenture.lkm.service;

import com.accenture.lkm.StudentAssignmentApplication;
import com.accenture.lkm.bean.StudentBean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = StudentAssignmentApplication.class)
public class StudentServiceTest {
    @Autowired
    StudentService service;

    @Test
    public void testAddStudentDetails() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        StudentBean bean = new StudentBean("Anjani Kumar",50,"B-Tech",format.parse("2024-05-23"),"New Delhi");
        if(bean.getStudentName().isEmpty())
        {
            throw new IllegalArgumentException("Student name should not be empty");
        }
        if(bean.getDept().length()<=3 && bean.getDept().length()<=20)
        {
            System.out.println("Department Length: "+bean.getDept().length());
            throw new IllegalArgumentException("Department string size should be between 3 to 20");
        }
        if(bean.getAge()<=18 && bean.getAge()<=45)
        {
            System.out.println("Input Age: "+bean.getDept().length());
            throw new IllegalArgumentException("Age should not be less than 18 and more than 45");
        }
        else
            System.out.println("Record added successfully: "+bean.toString());
    }
    @Test
    public void testGetStudentDetailsById()
    {
        int id=2;
        Assertions.assertTrue(service.getStudentDetailsById(id).getStudentId()==id);
        System.out.println(service.getStudentDetailsById(id));
    }
   @Test
    public void testGetAllStudentDetails()
    {
        List<StudentBean> list = new ArrayList<>(service.getAllStudentDetails());
        Assertions.assertTrue(list!=null);
    }
    @Test
    public void testGetDataByRegistrationDateAfter()
    {
        Date date = service.getStudentDetailsById(2).getRegistrationDate();
        Assertions.assertTrue(service.getDataByRegistrationDateAfter(date)!=null);
        System.out.println(service.getDataByRegistrationDateAfter(date));
    }
    @Test
    public void testGetDataByDeptAndAge()
    {
        String dept = "ITE";
        int age=45;
        Assertions.assertTrue(service.getDataByDeptAndAge(dept,age)!=null);
        System.out.println(service.getDataByDeptAndAge(dept,age));

    }
}
