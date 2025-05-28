package com.wzb;

import com.wzb.mapper.EmpMapper;
import com.wzb.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        emp.setUsername("test");
        emp.setPassword("123456");
        empMapper.insert(emp);
    }

    /**
     * 删除测试
     */
    @Test
    public void deleteTest() {
        empMapper.deleteById("38");
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
