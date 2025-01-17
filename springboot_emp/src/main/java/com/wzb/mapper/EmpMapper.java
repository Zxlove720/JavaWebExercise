package com.wzb.mapper;

import com.wzb.pojo.Emp;
import com.wzb.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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

    /**
     * 新增员工
     * @param emp 员工实体对象
     */
    @Insert("insert into emp(username, name, gender, phone, job, salary, " +
            "image, entry_date, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{phone}, " +
            "#{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    // 添加员工工作经历时需要使用员工id，MyBatis可以设置主键返回，可以返回id主键
    void insertEmp(Emp emp);

}
