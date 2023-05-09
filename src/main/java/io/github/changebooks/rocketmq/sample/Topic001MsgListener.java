package io.github.changebooks.rocketmq.sample;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.bean.Subscription;
import io.github.changebooks.rocketmq.RocketMqListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author changebooks@qq.com
 */
@Service
public class Topic001MsgListener implements RocketMqListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Topic001MsgListener.class);

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        LOGGER.info("consume, message: {}", new String(message.getBody(), StandardCharsets.UTF_8));
        return Action.CommitMessage;
    }

    @Override
    public Subscription subscription() {
        Subscription subscription = new Subscription();

        subscription.setTopic(RocketMqSupportImpl.TOPIC);
        subscription.setExpression(RocketMqSupportImpl.TAG);

        return subscription;
    }

}
