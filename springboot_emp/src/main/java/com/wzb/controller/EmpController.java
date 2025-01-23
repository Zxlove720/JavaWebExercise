package com.wzb.controller;


import com.wzb.annotation.LogOperation;
import com.wzb.pojo.Emp;
import com.wzb.pojo.EmpQueryParam;
import com.wzb.pojo.PageResult;
import com.wzb.pojo.Result;
import com.wzb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

//    /**
//     * 条件分页查询所有员工
//     * @param page 当前要查询第几页
//     * @param pageSize 每一页显示的最多记录数
//     * @return Result<PageResult>
//     */
//    @GetMapping
//    public Result<PageResult<Emp>> selectAllEmp(
//            @RequestParam(defaultValue = "1")Integer page, // 起始页码，默认是1
//            @RequestParam(defaultValue = "10")Integer pageSize, // 每一页最多显示记录数，默认是10
//            String name, // 查询条件：员工姓名
//            Integer gender, // 查询条件：员工性别
//            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin, // 查询条件：起始时间
//            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end // 查询条件：结束时间
//            ) {
//        // 记录日志
//        log.info("分页查询员工信息，page = {}，pageSize = {}", page, pageSize);
//        log.info("查询条件：name：{}， gender：{}，begin：{}，end：{}", name, (gender == 1 ? "男" : "女"), begin, end);
//        // 加入查询条件的分页查询
//        PageResult<Emp> pageResult = empService.selectAllEmp(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }


    /**
     * 条件分页查询员工信息
     * 直接在方法形参列表中声明请求参数过于冗杂，不方便，
     * 将请求参数封装成对应的实体类对象即可（实体类属性名必须和前端请求参数一致！）
     * @param empQueryParam 将请求参数封装的对应实体类，方便使用
     * @return Result<PageResult<Emp>>
     */
    @GetMapping
    @LogOperation
    public Result<PageResult<Emp>> selectAllEmp(EmpQueryParam empQueryParam) {
        log.info("分页查询员工信息，请求参数：{}", empQueryParam);
        PageResult<Emp> pageResult = empService.selectAllEmp(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增一个员工
     * @param emp 员工实体对象
     * @return Result<Void>
     */
    @PostMapping
    @LogOperation
    public Result<Void> addEmp(@RequestBody Emp emp)  {
        log.info("新增一个员工：{}", emp);
        empService.addEmp(emp);
        return Result.success();
    }

}
