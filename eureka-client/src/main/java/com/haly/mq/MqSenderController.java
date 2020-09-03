package com.haly.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MqSenderController
 * @Date 2020-09-03 11:30
 * @description 发送mq消息
 **/
@RestController
public class MqSenderController {

    @Autowired
    private Sender sender;

    @RequestMapping("/mqSend")
    public void hello() {
        sender.send();
    }

    @RequestMapping("/mqSend2")
    public void hello2(@RequestBody Message messgae) {
        sender.sendMessage(messgae);
    }

}
