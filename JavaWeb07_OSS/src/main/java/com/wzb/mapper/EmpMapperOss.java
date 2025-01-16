package com.wzb.mapper;

import com.wzb.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapperOss {

    public List<Emp> selectEmp(String name, int gender, LocalDate begin, LocalDate end);

    public void deleteEmp(List<Integer> ids);

    public void updateEmp(Emp emp);


}
