package com.wzb.controller;

import com.wzb.pojo.Dept;
import com.wzb.pojo.Result;
import com.wzb.service.DeptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 查询所有部门
     * @return result - 部门集合
     */
    @RequestMapping("/dept")
    public Result<List<Dept>> selectAllDept() {
        List<Dept> deptList = deptService.selectAllDept();
        return Result.success(deptList);
    }

}
