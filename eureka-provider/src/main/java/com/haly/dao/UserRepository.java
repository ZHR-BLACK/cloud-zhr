package com.haly.dao;

import com.haly.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserRepository
 * @Date 2020-09-07 10:24
 * @description UserRepository
 **/
@Mapper
public interface UserRepository {

    List<User> getList();
}
