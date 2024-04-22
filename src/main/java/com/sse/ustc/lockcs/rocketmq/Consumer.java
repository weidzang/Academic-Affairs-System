package com.sse.ustc.lockcs.rocketmq;

import com.sse.ustc.lockcs.student.service.ServiceStudent;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: consumer
 * Package: com.sse.ustc.lockcs.rocketmq
 * Description:
 *
 * @Author: zwd
 * @Create: 2023/6/8 - 14:55
 * @Version: v1.0
 */
@Component
@RocketMQMessageListener(consumerGroup = "my-producer-group",topic = "select-course",consumeMode = ConsumeMode.ORDERLY)
public class Consumer implements RocketMQListener<Message> {
    @Autowired
    ServiceStudent service;
    @Override
    public void onMessage(Message message) {
        int y=service.cs_selectOneCourse(message.getSid(), message.getCid());
    }
}
