package com.wzb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wzb.Enum.DeleteEnum;
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
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private Integer balance;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private DeleteEnum deleted;

    public User(Integer id, String username, String phone, Integer balance, LocalDateTime createTime, LocalDateTime updateTime, DeleteEnum deleted) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.balance = balance;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }
}
