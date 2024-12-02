package com.wzb.mapper;

import com.wzb.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    public List<Emp> selectEmp(String name, int gender, LocalDate begin, LocalDate end);

}