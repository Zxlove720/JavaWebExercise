package com.wzb.mapper;

import com.wzb.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历信息
     * @param exprList 员工工作经历表
     */
    void insertBatch(List<EmpExpr> exprList);
}
