package com.soap.spring.listener;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by ipaynow0929 on 2018/1/12.
 */
public class MyAppListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        SpringApplication app = applicationStartedEvent.getSpringApplication();
        app.setBannerMode(Banner.Mode.OFF);
    }
}
