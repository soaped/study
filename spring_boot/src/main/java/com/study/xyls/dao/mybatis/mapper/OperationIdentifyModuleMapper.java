package com.study.xyls.dao.mybatis.mapper;

import com.study.xyls.dao.mybatis.domain.OperationIdentifyModule;
import com.study.xyls.dao.mybatis.domain.OperationIdentifyModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyModuleMapper {
    int countByExample(OperationIdentifyModuleExample example);

    int deleteByExample(OperationIdentifyModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyModule record);

    int insertSelective(OperationIdentifyModule record);

    List<OperationIdentifyModule> selectByExample(OperationIdentifyModuleExample example);

    OperationIdentifyModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyModule record, @Param("example") OperationIdentifyModuleExample example);

    int updateByExample(@Param("record") OperationIdentifyModule record, @Param("example") OperationIdentifyModuleExample example);

    int updateByPrimaryKeySelective(OperationIdentifyModule record);

    int updateByPrimaryKey(OperationIdentifyModule record);
}