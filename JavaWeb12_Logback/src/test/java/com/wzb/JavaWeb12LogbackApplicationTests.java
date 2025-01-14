package com.wzb;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class JavaWeb12LogbackApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(JavaWeb12LogbackApplicationTests.class);

    @Test
    public void testLogback() {
        log.info("开始计算");
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        log.info("计算结果为{}", sum);
        log.info("{}结束计算", LocalDateTime.now());
    }
}
