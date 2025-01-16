package com.wzb.controller;

import com.wzb.pojo.Dept;
import com.wzb.pojo.Result;
import com.wzb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
        log.info("查询所有部门信息");
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

    /**
     * 新增部门
     * @param dept RequestBody中的数据
     * @return result
     */
    @PostMapping("/depts")
    public Result<Void> addDept(@RequestBody Dept dept) {
        log.info("新增部门{}", dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id 需要查询的部门id
     * @return result<Dept>
     */
    @GetMapping("/depts/{id}")
    public Result<Dept> selectById(@PathVariable Integer id) {
        log.info("根据id查询部门{}", id);
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     * @param dept 请求数据封装的Dept实体对象
     * @return result
     */
    @PutMapping("/depts")
    public Result<Void> updateDept(@RequestBody Dept dept) {
        log.info("修改部门信息{}", dept);
        deptService.updateDept(dept);
        return Result.success();
    }

}
