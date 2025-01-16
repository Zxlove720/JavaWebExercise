package com.wzb.controller;


import com.wzb.pojo.Emp;
import com.wzb.pojo.PageResult;
import com.wzb.pojo.Result;
import com.wzb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    /**
     * 分页查询所有员工
     * @param page 当前要查询第几页
     * @param pageSize 每一页显示的最多记录数
     * @return Result<PageResult>
     */
    @GetMapping
    public Result<PageResult<Emp>> selectAllEmp(Integer page, Integer pageSize) {
        log.info("分页查询员工信息，page = {}，pageSize = {}", page, pageSize);
        PageResult<Emp> pageResult = empService.selectAllEmp(page, pageSize);
        return Result.success(pageResult);
    }

}
