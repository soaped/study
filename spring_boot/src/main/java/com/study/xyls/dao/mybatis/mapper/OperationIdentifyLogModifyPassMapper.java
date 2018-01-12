package com.study.xyls.dao.mybatis.mapper;

import com.study.xyls.dao.mybatis.domain.OperationIdentifyLogModifyPass;
import com.study.xyls.dao.mybatis.domain.OperationIdentifyLogModifyPassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyLogModifyPassMapper {
    int countByExample(OperationIdentifyLogModifyPassExample example);

    int deleteByExample(OperationIdentifyLogModifyPassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyLogModifyPass record);

    int insertSelective(OperationIdentifyLogModifyPass record);

    List<OperationIdentifyLogModifyPass> selectByExample(OperationIdentifyLogModifyPassExample example);

    OperationIdentifyLogModifyPass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyLogModifyPass record, @Param("example") OperationIdentifyLogModifyPassExample example);

    int updateByExample(@Param("record") OperationIdentifyLogModifyPass record, @Param("example") OperationIdentifyLogModifyPassExample example);

    int updateByPrimaryKeySelective(OperationIdentifyLogModifyPass record);

    int updateByPrimaryKey(OperationIdentifyLogModifyPass record);
}