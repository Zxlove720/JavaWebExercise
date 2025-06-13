package com.wzb;

import com.wzb.mapper.EmpMapper;
import com.wzb.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 测试类
 */
@SpringBootTest
class JavaWeb13MyBatisPlusApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 查询测试
     */
    @Test
    public void queryTest() {
        Emp emp = empMapper.selectById(1);
        System.out.println(emp);
    }

    /**
     * 增加测试
     */
    @Test
    public void insertTest() {
        Emp emp = new Emp();
        emp.setId(100);
        emp.setUsername("测试员工");
        emp.setPassword("123456");
        emp.setName("测试员工");
        emp.setGender(0);
        emp.setPhone("1310000001");
        emp.setImage("https://123.com");
        emp.setJob(1);
        emp.setEntryDate(LocalDate.now());
        emp.setDeptId(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    /**
     * 删除测试
     */
    @Test
    public void deleteTest() {
        empMapper.deleteById("100");
    }

    /**
     * 修改测试
     */
    @Test
    public void updateTest() {
        Emp emp = new Emp();
        emp.setId(1);
        emp.setUsername("张三");
        empMapper.updateById(emp);
    }

}
