package com.xyls.common.flow;

import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class InvokeRate {


	/*
	log4j.appender.invokeRate=org.apache.log4j.DailyRollingFileAppender
	log4j.appender.invokeRate.File=xxxx
	log4j.appender.invokeRate.DatePattern='.'yyyy-MM-dd
	log4j.appender.invokeRate.layout=org.apache.log4j.PatternLayout
	log4j.appender.invokeRate.layout.ConversionPattern=%d{ss} -> %m%n
	log4j.logger.com.aspire.nm.component.commonUtil.flow.InvokeRate=debug,invokeRate
    log4j.additivity.com.aspire.nm.component.commonUtil.flow.InvokeRate=false
	 */
	private static Logger logger = Logger.getLogger(InvokeRate.class);
	
	private AtomicInteger count = new AtomicInteger(0);
	private AtomicLong totalCount = new AtomicLong(0);
	
	

    public InvokeRate(final String pointKey){
    	this(pointKey,1000);
    }
    public InvokeRate(final String pointKey,final int msec){
		
		Thread t = new Thread(){
			public void run(){
				while(true){
					try {
	                    Thread.sleep(msec);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
					if(count.intValue() != 0 || totalCount.longValue() != 0){
					    logger.debug(String.valueOf(count) +"/"+String.valueOf(totalCount)+" ("+pointKey+")");
					    count.set(0);
					}
				}
				
			}
		};
		t.setDaemon(true);
		t.start();
	}
	
	
	public void count(){
		count.incrementAndGet();
		totalCount.incrementAndGet();
	}
	
}
