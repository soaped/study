package com.study.xyls.dao.mybatis.mapper;

import com.study.xyls.dao.mybatis.domain.OperationIdentifyPermission;
import com.study.xyls.dao.mybatis.domain.OperationIdentifyPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyPermissionMapper {
    int countByExample(OperationIdentifyPermissionExample example);

    int deleteByExample(OperationIdentifyPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyPermission record);

    int insertSelective(OperationIdentifyPermission record);

    List<OperationIdentifyPermission> selectByExample(OperationIdentifyPermissionExample example);

    OperationIdentifyPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyPermission record, @Param("example") OperationIdentifyPermissionExample example);

    int updateByExample(@Param("record") OperationIdentifyPermission record, @Param("example") OperationIdentifyPermissionExample example);

    int updateByPrimaryKeySelective(OperationIdentifyPermission record);

    int updateByPrimaryKey(OperationIdentifyPermission record);
}