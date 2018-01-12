package com.ipaynow.hr.schedule;

import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by ipaynow0929 on 2018/1/11.
 */
@Component
public class TaskTest {

    /**
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @Scheduled(cron="* 5 * * * ") ：通过cron表达式定义规则
     */
    @Scheduled(fixedDelay = 50000)
    public void task(){
        System.out.println(new DateTime().toString("yyyyMMdd HH:mm:ss EE", Locale.CHINESE));
    }
}
