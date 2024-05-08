package com.accenture.lkm.service;

import com.accenture.lkm.bean.StudentBean;

import java.util.Date;
import java.util.List;

public interface StudentService {
    public Integer addStudentDetails(StudentBean studentBean);
    public StudentBean getStudentDetailsById(int id);
    public String updateStudentDetails(int id, StudentBean newBean);
    public String deleteStudentDetailsById(int id);
    public List<StudentBean> getAllStudentDetails();
    public List<StudentBean> getDataByRegistrationDateAfter(Date date);
    public List<StudentBean> getDataByDeptAndAge(String dept,int age);
}
