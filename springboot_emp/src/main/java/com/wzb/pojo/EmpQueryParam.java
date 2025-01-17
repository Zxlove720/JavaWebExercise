package com.wzb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 封装员工查询的查询条件参数的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpQueryParam {
    // 分页查询查询页码，默认为1
    private Integer page = 1;
    // 分页查询每页最大记录数
    private Integer pageSize = 10;
    private String name;
    private Integer gender;
    // 入职开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    // 入职结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
