package com.wzb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录成功结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    // 登录员工的id
    private Integer id;
    private String username;
    private String name;
    // 返回的JWT令牌
    private String token;
}
