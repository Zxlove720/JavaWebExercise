package com.wzb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * User实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    private String username;

    private String password;

    private String phone;

    private int balance;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
