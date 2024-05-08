package com.accenture.lkm.dao;

import com.accenture.lkm.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StudentDao extends CrudRepository<StudentEntity,Integer> {

    List<StudentEntity> findByRegistrationDateAfter(Date date);
    @Query("select s from StudentEntity s where s.dept=:d and s.age=:a")
    List<StudentEntity> findByDeptAndAge(@Param(("d")) String dept,@Param("a") int age);
}
