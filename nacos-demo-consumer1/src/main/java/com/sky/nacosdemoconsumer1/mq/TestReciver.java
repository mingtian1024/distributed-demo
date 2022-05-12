package com.sky.nacosdemoconsumer1.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;
import com.sky.api.system.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(queues = "test_direct_queue")
public class TestReciver {
    @RabbitHandler
    public void process(User user, Channel channel){
        System.out.println("process1 收到消息=========");
        System.out.println(user);
        System.out.println(channel);
    }

    @RabbitHandler
    public void process(Envelope envelope, Channel channel,Map map) throws IOException {
        System.out.println("process2  收到消息=========");
        System.out.println(map);
        System.out.println(channel);
        channel.basicAck(envelope.getDeliveryTag(),false);
    }
}
