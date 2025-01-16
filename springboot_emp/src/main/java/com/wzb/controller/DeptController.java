package com.wzb.controller;

import com.wzb.pojo.Dept;
import com.wzb.pojo.Result;
import com.wzb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
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
    @GetMapping("/depts") // 建议使用衍生注解，更加简洁、优雅
    public Result<List<Dept>> selectAllDept() {
        List<Dept> deptList = deptService.selectAllDept();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门
     * @param id 部门id
     * @return result
     */
    @DeleteMapping("/depts")
    public Result<Void> deleteDept(Integer id) {
        log.info("根据id删除部门{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

}
