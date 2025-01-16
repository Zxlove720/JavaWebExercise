package com.wzb.service;

import com.wzb.pojo.Emp;
import com.wzb.pojo.PageResult;

public interface EmpService {

    PageResult<Emp> selectAllEmp(Integer page, Integer pageSize);

}
