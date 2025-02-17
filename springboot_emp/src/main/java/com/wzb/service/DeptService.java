package com.wzb.service;

import com.wzb.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> selectAllDept();

    void deleteById(Integer id);

    void addDept(Dept dept);

    Dept selectById(Integer id);

    void updateDept(Dept dept);
}
