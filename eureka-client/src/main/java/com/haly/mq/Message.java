package com.haly.mq;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Message
 * @Date 2020-09-03 14:50
 * @description 消息体
 **/
@Data
public class Message implements Serializable{

    private Long id;
    private String msg;
}
