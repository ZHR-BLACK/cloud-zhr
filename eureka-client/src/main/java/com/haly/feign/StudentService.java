package com.haly.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StudentService
 * @Date 2020-09-01 15:07
 * @description feign API接口
 **/
@FeignClient(name = "eureka-provider", fallback = StudentServiceFallback.class)
public interface StudentService {

    /**
     * 获取所有学生列表
     *
     * @return
     */
    @GetMapping(value = "/myfeign/student")
    String getAllStudent();

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @PostMapping(value = "/myfeign/student")
    String saveStudent(@RequestBody Student student);

}
