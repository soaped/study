package com.study.xyls.dao.mybatis.mapper;

import com.study.xyls.dao.mybatis.domain.OperationIdentifyBranch;
import com.study.xyls.dao.mybatis.domain.OperationIdentifyBranchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationIdentifyBranchMapper {
    int countByExample(OperationIdentifyBranchExample example);

    int deleteByExample(OperationIdentifyBranchExample example);

    int deleteByPrimaryKey(Integer brhCd);

    int insert(OperationIdentifyBranch record);

    int insertSelective(OperationIdentifyBranch record);

    List<OperationIdentifyBranch> selectByExample(OperationIdentifyBranchExample example);

    OperationIdentifyBranch selectByPrimaryKey(Integer brhCd);

    int updateByExampleSelective(@Param("record") OperationIdentifyBranch record, @Param("example") OperationIdentifyBranchExample example);

    int updateByExample(@Param("record") OperationIdentifyBranch record, @Param("example") OperationIdentifyBranchExample example);

    int updateByPrimaryKeySelective(OperationIdentifyBranch record);

    int updateByPrimaryKey(OperationIdentifyBranch record);
}