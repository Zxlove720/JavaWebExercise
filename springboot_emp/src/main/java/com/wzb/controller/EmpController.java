package com.wzb.controller;


import com.wzb.pojo.Emp;
import com.wzb.pojo.PageResult;
import com.wzb.pojo.Result;
import com.wzb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


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
     * 条件分页查询所有员工
     * @param page 当前要查询第几页
     * @param pageSize 每一页显示的最多记录数
     * @return Result<PageResult>
     */
    @GetMapping
    public Result<PageResult<Emp>> selectAllEmp(
            @RequestParam(defaultValue = "1")Integer page, // 起始页码，默认是1
            @RequestParam(defaultValue = "10")Integer pageSize, // 每一页最多显示记录数，默认是10
            String name, // 查询条件：员工姓名
            Integer gender, // 查询条件：员工性别
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin, // 查询条件：起始时间
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end // 查询条件：结束时间
            ) {
        // 记录日志
        log.info("分页查询员工信息，page = {}，pageSize = {}", page, pageSize);
        log.info("查询条件：name：{}， gender：{}，begin：{}，end：{}", name, (gender == 1 ? "男" : "女"), begin, end);

        PageResult<Emp> pageResult = empService.selectAllEmp(page, pageSize);
        return Result.success(pageResult);
    }

}
