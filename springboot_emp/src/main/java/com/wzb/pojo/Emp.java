package com.wzb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 员工信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    // 性别 1：男   2：女
    private Integer gender;
    private String phone;
    // 职位 1：班主任 2：讲师 3：学工主管 4：教研主管 5：咨询师
    private Integer job;
    private Integer salary;
    // 头像
    private String image;
    private LocalDate entryDate;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
