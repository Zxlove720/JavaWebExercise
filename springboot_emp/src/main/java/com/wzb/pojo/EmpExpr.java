package com.wzb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 员工工作经历
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpExpr {
    private Integer id;
    // 员工id
    private Integer empId;
    private LocalDate begin;
    private LocalDate end;
    private String company;
    private String job;
}
