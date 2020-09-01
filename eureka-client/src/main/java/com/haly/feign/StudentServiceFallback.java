package com.haly.feign;

import org.springframework.stereotype.Component;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StudentServiceFallback
 * @Date 2020-09-01 16:25
 * @description todo
 **/
@Component
public class StudentServiceFallback implements StudentService{

    @Override
    public String getAllStudent() {
        System.out.println("触发熔断");
        return "fail";
    }

    @Override
    public String saveStudent(Student student) {
        System.out.println("触发熔断:" + student);
        return "fail";
    }
}
