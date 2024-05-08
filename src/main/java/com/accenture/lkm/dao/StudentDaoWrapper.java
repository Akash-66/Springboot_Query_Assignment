package com.accenture.lkm.dao;

import com.accenture.lkm.bean.StudentBean;
import com.accenture.lkm.entity.StudentEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StudentDaoWrapper {
    @Autowired
    StudentDao studentDao;

    public Integer addStudent(StudentBean studentBean)
    {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentBean,studentEntity);
        studentDao.save(studentEntity);
        return studentEntity.getStudentId();
    }
    public StudentBean getStudentById(int id)
    {
        StudentBean studentBean = new StudentBean();
        if(studentDao.findById(id).isEmpty())
            return null;
        StudentEntity studentEntity = studentDao.findById(id).get();
        BeanUtils.copyProperties(studentEntity,studentBean);
        return studentBean;
    }
    public String updateStudent(int id, StudentBean newBean)
    {
        return studentDao.findById(id).map(
                studentEntity -> {
                    studentEntity.setStudentName(newBean.getStudentName());
                    studentEntity.setAge(newBean.getAge());
                    studentEntity.setDept(newBean.getDept());
                    studentEntity.setRegistrationDate(newBean.getRegistrationDate());
                    studentEntity.setAddress(newBean.getAddress());
                    studentDao.save(studentEntity);
                    return "Record updated successfully !";
                }
        ).orElse("Student Id not found");
    }
    public String deleteStudent(int id)
    {
        if(studentDao.findById(id).isEmpty())
        {
            return "Student Id not found";
        }
        else {
            studentDao.deleteById(id);
            return "Record deleted successfully !";
        }
    }
    public List<StudentBean> getAllStudent()
    {
        List<StudentBean> studentBeanList = new ArrayList<>();
        List<StudentEntity> entityList = (List<StudentEntity>) studentDao.findAll();
        for(StudentEntity studentEntity : entityList)
        {
            StudentBean bean = new StudentBean();
            BeanUtils.copyProperties(studentEntity,bean);
            studentBeanList.add(bean);
        }
        return studentBeanList;
    }
    public List<StudentBean> getByRegistrationDateAfter(Date date)
    {
        List<StudentBean> list = new ArrayList<>();
        List<StudentEntity> entityList = (List<StudentEntity>) studentDao.findByRegistrationDateAfter(date);
        //System.out.println(entityList);
        for(StudentEntity studentEntity:entityList)
        {
            StudentBean studentBean = new StudentBean();
            BeanUtils.copyProperties(studentEntity,studentBean);
            list.add(studentBean);
        }
        return list;
    }
    public List<StudentBean> getByDeptAndAge(String dept,int age)
    {
        List<StudentBean> list = new ArrayList<>();
        List<StudentEntity> entityList = (List<StudentEntity>) studentDao.findByDeptAndAge(dept,age);
        for(StudentEntity studentEntity:entityList)
        {
            StudentBean studentBean = new StudentBean();
            BeanUtils.copyProperties(studentEntity,studentBean);
            list.add(studentBean);
        }
        return list;
    }
}
