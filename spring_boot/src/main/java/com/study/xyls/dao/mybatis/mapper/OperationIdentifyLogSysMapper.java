package com.study.yfz.dao.mybatis.mapper;

import com.study.yfz.dao.mybatis.domain.OperationIdentifyLogSys;
import com.study.yfz.dao.mybatis.domain.OperationIdentifyLogSysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyLogSysMapper {
    int countByExample(OperationIdentifyLogSysExample example);

    int deleteByExample(OperationIdentifyLogSysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyLogSys record);

    int insertSelective(OperationIdentifyLogSys record);

    List<OperationIdentifyLogSys> selectByExample(OperationIdentifyLogSysExample example);

    OperationIdentifyLogSys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyLogSys record, @Param("example") OperationIdentifyLogSysExample example);

    int updateByExample(@Param("record") OperationIdentifyLogSys record, @Param("example") OperationIdentifyLogSysExample example);

    int updateByPrimaryKeySelective(OperationIdentifyLogSys record);

    int updateByPrimaryKey(OperationIdentifyLogSys record);
}