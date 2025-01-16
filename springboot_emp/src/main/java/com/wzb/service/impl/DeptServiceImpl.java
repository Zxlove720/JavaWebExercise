package com.wzb.service.impl;

import com.wzb.mapper.DeptMapper;
import com.wzb.pojo.Dept;
import com.wzb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;

    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    /**
     * 查询所有部门
     * @return 部门集合
     */
    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }
}
