package com.haly.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// feign API接口
public interface StudentService {

    @GetMapping(value = "/myfeign/student")
    String getAllStudent();

    @PostMapping(value = "/myfeign/student")
    String saveStudent(@RequestBody Student student);
}
