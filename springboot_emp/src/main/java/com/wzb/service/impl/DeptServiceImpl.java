package com.wzb.service.impl;

import com.wzb.mapper.DeptMapper;
import com.wzb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;

    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }
}
