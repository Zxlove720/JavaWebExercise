package com.wzb;

import com.wzb.mapper.EmpMapper;
import com.wzb.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaWeb13MyBatisPlusApplicationTests {

    private final EmpMapper empMapper;

    @Autowired
    public JavaWeb13MyBatisPlusApplicationTests(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    /**
     * 查询测试
     */
    @Test
    public void queryTest() {
        Emp emp = empMapper.selectById(1);
        System.out.println(emp);
    }

}
