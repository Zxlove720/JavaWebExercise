package com.wzb.service;

import com.wzb.pojo.Emp;
import com.wzb.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {

    PageResult<Emp> selectAllEmp(Integer page, Integer pageSize, String name,
                                 Integer gender, LocalDate begin, LocalDate end);

}
