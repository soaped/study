package com.study.xyls.dao.mybatis.mapper;

import com.study.xyls.dao.mybatis.domain.OperationIdentifyRole;
import com.study.xyls.dao.mybatis.domain.OperationIdentifyRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyRoleMapper {
    int countByExample(OperationIdentifyRoleExample example);

    int deleteByExample(OperationIdentifyRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyRole record);

    int insertSelective(OperationIdentifyRole record);

    List<OperationIdentifyRole> selectByExample(OperationIdentifyRoleExample example);

    OperationIdentifyRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyRole record, @Param("example") OperationIdentifyRoleExample example);

    int updateByExample(@Param("record") OperationIdentifyRole record, @Param("example") OperationIdentifyRoleExample example);

    int updateByPrimaryKeySelective(OperationIdentifyRole record);

    int updateByPrimaryKey(OperationIdentifyRole record);
}