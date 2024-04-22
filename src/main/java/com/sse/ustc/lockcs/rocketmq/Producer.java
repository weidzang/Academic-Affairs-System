package com.sse.ustc.lockcs.rocketmq;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: producer
 * Package: com.sse.ustc.lockcs.rocketmq
 * Description:
 *
 * @Author: zwd
 * @Create: 2023/6/8 - 14:39
 * @Version: v1.0
 */
@Component
public class Producer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    public void sendMessage(String topic, Message message){
        rocketMQTemplate.convertAndSend(topic, message);
    }
}
