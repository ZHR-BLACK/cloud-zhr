package com.haly.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StudentController
 * @Date 2020-09-01 15:12
 * @description StudentController
 **/
@RestController
public class StudentController implements StudentService {

    @Autowired
    @Qualifier("iStudentServiceImp")
    StudentService studentService;

    @Override
    public String getAllStudent() {
        return studentService.getAllStudent();
    }

    @Override
    public String saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

}
