package com.study.xyls.dao.mybatis.mapper;

import com.study.xyls.dao.mybatis.domain.OperationIdentifyLogLogin;
import com.study.xyls.dao.mybatis.domain.OperationIdentifyLogLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyLogLoginMapper {
    int countByExample(OperationIdentifyLogLoginExample example);

    int deleteByExample(OperationIdentifyLogLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyLogLogin record);

    int insertSelective(OperationIdentifyLogLogin record);

    List<OperationIdentifyLogLogin> selectByExample(OperationIdentifyLogLoginExample example);

    OperationIdentifyLogLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyLogLogin record, @Param("example") OperationIdentifyLogLoginExample example);

    int updateByExample(@Param("record") OperationIdentifyLogLogin record, @Param("example") OperationIdentifyLogLoginExample example);

    int updateByPrimaryKeySelective(OperationIdentifyLogLogin record);

    int updateByPrimaryKey(OperationIdentifyLogLogin record);
}