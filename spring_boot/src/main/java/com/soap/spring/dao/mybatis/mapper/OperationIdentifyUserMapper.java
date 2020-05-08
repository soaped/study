package com.soap.spring.dao.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soap.spring.dao.mybatis.domain.OperationIdentifyUser;
import java.util.List;


/**
 * @author yangfuzhao on 2020/1/19.
 */
public interface OperationIdentifyUserMapper extends BaseMapper<OperationIdentifyUser> {
    int updateBatch(List<OperationIdentifyUser> list);
}