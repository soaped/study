package com.study.yfz.dao.mybatis.mapper;

import com.study.yfz.dao.mybatis.domain.OperationIdentifyRolePermission;
import com.study.yfz.dao.mybatis.domain.OperationIdentifyRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyRolePermissionMapper {
    int countByExample(OperationIdentifyRolePermissionExample example);

    int deleteByExample(OperationIdentifyRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyRolePermission record);

    int insertSelective(OperationIdentifyRolePermission record);

    List<OperationIdentifyRolePermission> selectByExample(OperationIdentifyRolePermissionExample example);

    OperationIdentifyRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyRolePermission record, @Param("example") OperationIdentifyRolePermissionExample example);

    int updateByExample(@Param("record") OperationIdentifyRolePermission record, @Param("example") OperationIdentifyRolePermissionExample example);

    int updateByPrimaryKeySelective(OperationIdentifyRolePermission record);

    int updateByPrimaryKey(OperationIdentifyRolePermission record);
}