package io.github.changebooks.rocketmq.sample;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author changebooks@qq.com
 */
@Service
public class Topic001MsgSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Topic001MsgSender.class);

    @Resource
    private ProducerBean topic001Producer;

    /**
     * 发送消息
     *
     * @param value 消息内容
     */
    public void send(String value) {
        Message message = new Message();
        message.setTopic(RocketMqSupportImpl.TOPIC);
        message.setTag(RocketMqSupportImpl.TAG);
        message.setBody(value.getBytes());

        SendResult sendResult = topic001Producer.send(message);
        LOGGER.info("send trace, value: {}, thread: {}, sendResult: {}", value, Thread.currentThread().getId(), sendResult);
    }

}
