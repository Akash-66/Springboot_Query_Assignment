package com.accenture.lkm.service;

import com.accenture.lkm.bean.StudentBean;
import com.accenture.lkm.dao.StudentDaoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentDaoWrapper studentDaoWrapper;
    @Override
    public Integer addStudentDetails(StudentBean studentBean) {
        return studentDaoWrapper.addStudent(studentBean);
    }

    @Override
    public StudentBean getStudentDetailsById(int id) {
        return studentDaoWrapper.getStudentById(id);
    }

    @Override
    public String updateStudentDetails(int id, StudentBean newBean) {
        return studentDaoWrapper.updateStudent(id, newBean);
    }

    @Override
    public String deleteStudentDetailsById(int id) {
        return studentDaoWrapper.deleteStudent(id);
    }

    @Override
    public List<StudentBean> getAllStudentDetails() {
        return studentDaoWrapper.getAllStudent();
    }

    @Override
    public List<StudentBean> getDataByRegistrationDateAfter(Date date) {
        return studentDaoWrapper.getByRegistrationDateAfter(date);
    }

    @Override
    public List<StudentBean> getDataByDeptAndAge(String dept, int age) {
        return studentDaoWrapper.getByDeptAndAge(dept,age);
    }
}
