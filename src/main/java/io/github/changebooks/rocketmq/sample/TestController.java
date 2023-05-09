package io.github.changebooks.rocketmq.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author changebooks@qq.com
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Resource
    private Topic001MsgSender messageSender;

    @GetMapping(value = "/test")
    public void test(String message) {
        messageSender.send(message);
    }

}
