package com.wzb.service.impl;

import com.wzb.mapper.EmpMapper;
import com.wzb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    @Autowired
    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

}
