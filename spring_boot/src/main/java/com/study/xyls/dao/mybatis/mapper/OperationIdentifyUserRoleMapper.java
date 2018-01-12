package com.study.yfz.dao.mybatis.mapper;

import com.study.yfz.dao.mybatis.domain.OperationIdentifyUserRole;
import com.study.yfz.dao.mybatis.domain.OperationIdentifyUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyUserRoleMapper {
    int countByExample(OperationIdentifyUserRoleExample example);

    int deleteByExample(OperationIdentifyUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyUserRole record);

    int insertSelective(OperationIdentifyUserRole record);

    List<OperationIdentifyUserRole> selectByExample(OperationIdentifyUserRoleExample example);

    OperationIdentifyUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyUserRole record, @Param("example") OperationIdentifyUserRoleExample example);

    int updateByExample(@Param("record") OperationIdentifyUserRole record, @Param("example") OperationIdentifyUserRoleExample example);

    int updateByPrimaryKeySelective(OperationIdentifyUserRole record);

    int updateByPrimaryKey(OperationIdentifyUserRole record);
}