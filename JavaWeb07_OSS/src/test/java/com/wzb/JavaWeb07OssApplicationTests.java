package com.wzb;

import com.wzb.mapper.EmpMapper;
import com.wzb.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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

    @Test
    public void deleteEmpTest() {
        List<Integer> ids = new ArrayList<>();
        Collections.addAll(ids, 15, 16, 17);
        empMapper.deleteEmp(ids);
    }

    @Test
    public void updateEmpTest() {
        Emp emp = new Emp();
        emp.setId(17);
        emp.setUsername("tom");
        emp.setName("汤姆");
        emp.setGender(2);
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }

}
