package com.sse.ustc.lockcs;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: ProducerTests
 * Package: com.sse.ustc.lockcs
 * Description:
 *
 * @Author: zwd
 * @Create: 2023/6/8 - 15:17
 * @Version: v1.0
 */
@SpringBootTest
public class ProducerTests {
    @Autowired
    RocketMQTemplate rocketMQTemplate;
    @Test
    void test(){

    }
}
