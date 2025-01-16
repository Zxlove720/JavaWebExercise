package com.wzb.service.impl;

import com.wzb.mapper.DeptMapper;
import com.wzb.pojo.Dept;
import com.wzb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    /**
     * 根据id删除部门
     * @param id 部门id
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * 新增部门
     * @param dept json请求参数封装的实体对象
     */
    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertDept(dept);
    }

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return dept实体对象
     */
    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }

    /**
     * 修改部门信息
     * @param dept Dept实体对象
     */
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
 }
