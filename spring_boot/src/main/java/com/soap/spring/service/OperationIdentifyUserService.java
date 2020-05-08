package com.soap.spring.service;

import com.soap.spring.dao.mybatis.mapper.OperationIdentifyUserMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soap.spring.dao.mybatis.domain.OperationIdentifyUser;import java.util.List;


/**
 * @author yangfuzhao on 2020/1/19.
 */
@Service
public class OperationIdentifyUserService extends ServiceImpl<OperationIdentifyUserMapper, OperationIdentifyUser> {

    public int updateBatch(List<OperationIdentifyUser> list) {
        return baseMapper.updateBatch(list);
    }
}


