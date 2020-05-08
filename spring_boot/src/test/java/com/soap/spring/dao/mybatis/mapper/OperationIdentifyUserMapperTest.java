package com.soap.spring.dao.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soap.spring.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;


/**
 * @author yangfuzhao on 2020/1/19.
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class OperationIdentifyUserMapperTest {

    @Resource
    OperationIdentifyUserMapper operationIdentifyUserMapper;

    @Test
   public void updateBatch() {
        QueryWrapper qw = new QueryWrapper();
//        qw.groupBy();
        qw.eq("usr_cd","a");
        operationIdentifyUserMapper.selectList(qw);
    }
}