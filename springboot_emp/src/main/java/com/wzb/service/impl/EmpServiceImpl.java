package com.wzb.service.impl;

import com.wzb.mapper.EmpMapper;
import com.wzb.pojo.Emp;
import com.wzb.pojo.PageResult;
import com.wzb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 分页查询所有员工信息
     * @param page 当前页数
     * @param pageSize 每一页最大记录数
     * @return PageResult<Emp>
     */
    @Override
    public PageResult<Emp> selectAllEmp(Integer page, Integer pageSize) {
        // 获取总记录数
        Long total = empMapper.countEmp();

        // 获取分页查询的起始记录
        // 比如说我想要从第5页开始查，每一页最多10条记录，那么起始记录就是40（（5 - 1） * 10）
        Integer start = (page - 1) * pageSize;
        // 获取分页查询结果
        List<Emp> empList = empMapper.selectAllEmp(start, pageSize);

        // 封装结果并返回
        return new PageResult<>(total, empList);
    }
}
