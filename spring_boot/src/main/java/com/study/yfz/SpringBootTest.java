package com.study.yfz;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by ipaynow0929 on 2017/8/3.
 */
@RestController
@ConfigurationProperties(prefix = "user")
public class SpringBootTest {

    private static Logger logger = LoggerFactory.getLogger(SpringBootTest.class);

    @Getter
    @Setter
    private String user_name;

    @RequestMapping("/helloWorld")
    public void testPro(){
        System .out.print(user_name + "aaa");
    }

    @RequestMapping("/testFastJson")
    public Object testFastJson() {
        TestFastjson testFastjson = new TestFastjson();
        testFastjson.setAge(12);
        testFastjson.setName("老杨");
        testFastjson.setBr(new Date());
        logger.debug(testFastjson.getName());
        return testFastjson;
    }

    //localhost:8089/testHotStart
    @RequestMapping("/testHotStart")
    public String testHotStart(){
        return "testHotStart";
    }

    @Data
    class TestFastjson{

        private String name;

        private Integer age;

        @JSONField(format = "yyyy-MM-dd")
        private Date br;
    }

}
