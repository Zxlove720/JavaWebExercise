package com.wzb.controller;

import com.wzb.pojo.Dept;
import com.wzb.pojo.Result;
import com.wzb.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
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
    // 限定请求方式为GET
    // @RequestMapping(value = "/dept", method = RequestMethod.GET)
    @GetMapping("/dept") // 建议使用衍生注解，更加简洁、优雅
    public Result<List<Dept>> selectAllDept() {
        List<Dept> deptList = deptService.selectAllDept();
        return Result.success(deptList);
    }

}
