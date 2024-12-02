package com.wzb;

import com.wzb.mapper.EmpMapper;
import com.wzb.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavaWeb07OssApplicationTests {

    private EmpMapper empMapper;

    @Autowired
    public JavaWeb07OssApplicationTests(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }


    @Test
    public void selectEmpTest() {
        List<Emp> empList = empMapper.selectEmp(null, 1, null, null);
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

}
