package com.haly.feign;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StudentServiceImp
 * @Date 2020-09-01 15:11
 * @description todo
 **/
@Service("iStudentServiceImp")
public class StudentServiceImp implements StudentService{

    private static List<Student> studentList = new ArrayList<>();

    @Override
    public String getAllStudent() {
        return studentList.toString();
    }

    @Override
    public String saveStudent(Student student) {
        studentList.add(student);
        return "ok";
    }

}
