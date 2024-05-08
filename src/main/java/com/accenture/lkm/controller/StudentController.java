package com.accenture.lkm.controller;

import com.accenture.lkm.bean.StudentBean;
import com.accenture.lkm.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping(value = "/insertNewStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addStudentData(@Valid @RequestBody StudentBean studentBean, Errors errors)
    {
        if(errors.hasErrors())
            return new ResponseEntity<>(errors.getAllErrors(),HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(studentService.addStudentDetails(studentBean), HttpStatus.CREATED);
    }
    @GetMapping(value = "/studentDataById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getStudentById(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(studentService.getStudentDetailsById(id),HttpStatus.OK);
    }
    @GetMapping(value = "/allStudentData",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDetails()
    {
        return new ResponseEntity<>(studentService.getAllStudentDetails(),HttpStatus.OK);
    }
    @PutMapping(value = "/updateStudentData/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStudentDataById(@PathVariable("id") int id,@Valid @RequestBody StudentBean newBean, Errors errors)
    {
        if(errors.hasErrors())
            return new ResponseEntity<>(errors.getAllErrors(),HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(studentService.updateStudentDetails(id,newBean),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/deleteData/{id}")
    public ResponseEntity deleteData(@PathVariable("id") int id)
    {
        return  new ResponseEntity<>(studentService.deleteStudentDetailsById(id),HttpStatus.OK);
    }
    @GetMapping(value = "/studentDataByRegistrationDateAfter/{date}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getByRegistrationDateBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
    {
        return new ResponseEntity<>(studentService.getDataByRegistrationDateAfter(date),HttpStatus.OK);
    }
    @GetMapping(value = "/studentDataByDeptAndAge/dept={dept}-age={age}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getByDeptAndAge(@PathVariable("dept") String dept,@PathVariable("age") int age)
    {
        return new ResponseEntity<>(studentService.getDataByDeptAndAge(dept, age),HttpStatus.OK);
    }
}
