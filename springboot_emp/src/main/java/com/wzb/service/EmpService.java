package com.wzb.service;

import com.wzb.pojo.Emp;
import com.wzb.pojo.EmpQueryParam;
import com.wzb.pojo.LoginInfo;
import com.wzb.pojo.PageResult;


public interface EmpService {

    PageResult<Emp> selectAllEmp(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);

    LoginInfo login(Emp emp);

}
