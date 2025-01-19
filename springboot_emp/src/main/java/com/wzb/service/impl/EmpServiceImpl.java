package com.wzb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzb.mapper.EmpExprMapper;
import com.wzb.mapper.EmpMapper;
import com.wzb.pojo.*;
import com.wzb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    private final EmpExprMapper empExprMapper;

    @Autowired
    public EmpServiceImpl(EmpMapper empMapper, EmpExprMapper empExprMapper) {
        this.empMapper = empMapper;
        this.empExprMapper = empExprMapper;
    }

//    /**
//     * 分页查询所有员工信息
//     * @param page 当前页数
//     * @param pageSize 每一页最大记录数
//     * @return PageResult<Emp>
//     */
//    @Override
//    public PageResult<Emp> selectAllEmp(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long total = empMapper.countEmp();
//
//        // 获取分页查询的起始记录
//        // 比如说我想要从第5页开始查，每一页最多10条记录，那么起始记录就是40（（5 - 1） * 10）
//        Integer start = (page - 1) * pageSize;
//        // 获取分页查询结果
//        List<Emp> empList = empMapper.selectAllEmp(start, pageSize);
//
//        // 封装结果并返回
//        return new PageResult<>(total, empList);
//    }

    /**
     * 使用PageHelper插件进行员工信息分页查询
     * 加入分页查询的查询条件
     *
     * @param empQueryParam@return PageResult<Emp>
     */
    @Override
    public PageResult<Emp> selectAllEmp(EmpQueryParam empQueryParam) {
        // 使用PageHelper分页插件
        // 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 查询
        List<Emp> empList = empMapper.selectAllEmp(empQueryParam);
        // 转换查询结果
        Page<Emp> p = (Page<Emp>) empList;
        // 封装查询结果到PageResult对象中
        // 通过getTotal方法获取总记录数
        // 通过getResult方法获取分页查询结果
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 新增员工
     * @param emp 员工实体对象
     */
    @Override
    // 开启Spring事务机制 设置回滚类型为所有异常 事务传播机制为REQUIRES_NEW
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void addEmp(Emp emp) {
        // 为新增员工补全属性
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        // 新增员工
        empMapper.insertEmp(emp);
        // 批量添加员工工作经历
        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        // CollectionUtils.isEmpty不但会检查集合是否为空，还会检查集合是否为null
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }
    }

    /**
     * 员工登录
     * @param emp 登录请求数据封装的Emp实体对象
     * @return LoginInfo员工登录信息
     */
    @Override
    public LoginInfo login(Emp emp) {
        Emp empLogin = empMapper.getUserByUsernameAndPassword(emp);
        if (empLogin != null) {
            return new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), "");
        }
        return null;
    }
}
