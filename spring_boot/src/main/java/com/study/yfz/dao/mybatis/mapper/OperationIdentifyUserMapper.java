package com.study.yfz.dao.mybatis.mapper;

import com.study.yfz.dao.mybatis.domain.OperationIdentifyUser;
import com.study.yfz.dao.mybatis.domain.OperationIdentifyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyUserMapper {
    int countByExample(OperationIdentifyUserExample example);

    int deleteByExample(OperationIdentifyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationIdentifyUser record);

    int insertSelective(OperationIdentifyUser record);

    List<OperationIdentifyUser> selectByExample(OperationIdentifyUserExample example);

    OperationIdentifyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationIdentifyUser record, @Param("example") OperationIdentifyUserExample example);

    int updateByExample(@Param("record") OperationIdentifyUser record, @Param("example") OperationIdentifyUserExample example);

    int updateByPrimaryKeySelective(OperationIdentifyUser record);

    int updateByPrimaryKey(OperationIdentifyUser record);
}