package com.wzb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String username;

    private String password;

    private String phone;

    private int balance;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
