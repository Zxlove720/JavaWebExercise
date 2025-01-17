package com.wzb.mapper;

import com.wzb.pojo.Emp;
import com.wzb.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 统计员工数量，便于分页查询展示记录数
     * 但是使用PageHelper插件进行分页查询时，无需该方法
     * @return 员工总数
     */
    @Select("select count(*) from emp")
    Long countEmp();

//    /**
//     * 使用原始的方式分页查询员工信息
//     * @param start 分页查询的起始记录
//     * @param pageSize 每一页最多记录数
//     * @return List<Emp>
//     */
//    @Select("select * from emp as e left join dept as d on e.dept_id = d.id limit #{start}, #{pageSize}")
//    List<Emp> selectAllEmp(Integer start, Integer pageSize);

    /**
     * 使用PageHelper插件分页查询员工信息
     * 使用PageHelper插件时，无需在Mapper接口中提供起始记录start 和 pageSize等参数
     */
    List<Emp> selectAllEmp(EmpQueryParam empQueryParam);

}
