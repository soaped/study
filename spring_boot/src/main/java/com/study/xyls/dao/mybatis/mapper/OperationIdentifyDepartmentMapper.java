package com.study.yfz.dao.mybatis.mapper;

import com.study.yfz.dao.mybatis.domain.OperationIdentifyDepartment;
import com.study.yfz.dao.mybatis.domain.OperationIdentifyDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyDepartmentMapper {
    int countByExample(OperationIdentifyDepartmentExample example);

    int deleteByExample(OperationIdentifyDepartmentExample example);

    int deleteByPrimaryKey(Integer deptCd);

    int insert(OperationIdentifyDepartment record);

    int insertSelective(OperationIdentifyDepartment record);

    List<OperationIdentifyDepartment> selectByExample(OperationIdentifyDepartmentExample example);

    OperationIdentifyDepartment selectByPrimaryKey(Integer deptCd);

    int updateByExampleSelective(@Param("record") OperationIdentifyDepartment record, @Param("example") OperationIdentifyDepartmentExample example);

    int updateByExample(@Param("record") OperationIdentifyDepartment record, @Param("example") OperationIdentifyDepartmentExample example);

    int updateByPrimaryKeySelective(OperationIdentifyDepartment record);

    int updateByPrimaryKey(OperationIdentifyDepartment record);
}