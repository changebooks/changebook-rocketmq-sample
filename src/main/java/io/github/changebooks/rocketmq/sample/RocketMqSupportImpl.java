package io.github.changebooks.rocketmq.sample;

import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import io.github.changebooks.rocketmq.RocketMqProperties;
import io.github.changebooks.rocketmq.RocketMqSupport;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author changebooks@qq.com
 */
@Configuration
@EnableConfigurationProperties({RocketMqProperties.class})
public class RocketMqSupportImpl extends RocketMqSupport {

    public static final String TOPIC = "";
    public static final String TAG = "";

    @Resource
    private RocketMqProperties rocketMqProperties;

    @Resource
    private List<Topic001MsgListener> topic001MsgListeners;

    @Bean(name = "topic001Producer", initMethod = "start", destroyMethod = "shutdown")
    public ProducerBean topic001Producer() {
        return super.producerBean(rocketMqProperties.getProducer());
    }

    @Bean(name = "topic001Consumer", initMethod = "start", destroyMethod = "shutdown")
    public ConsumerBean topic001Consumer() {
        return super.consumerBean(rocketMqProperties.getConsumer(), topic001MsgListeners);
    }

}
