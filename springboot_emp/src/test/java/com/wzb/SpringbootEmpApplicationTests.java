package com.wzb;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
class SpringbootEmpApplicationTests {

    /**
     * 生成JWT令牌
     */
    @Test
    public void testGenerateJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "wzb");
        // 通过Jwts工具类中的builder方法构建一个JWT令牌
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "hello") // 加密算法和签名
                .addClaims(claims) // 添加数据：键值对
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)) // 设置JWT令牌有效期
                .compact(); // 生成令牌
        log.info("jwt令牌是：{}", jwt);
    }
}
