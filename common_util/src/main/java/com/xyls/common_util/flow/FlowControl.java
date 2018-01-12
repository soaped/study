package com.xyls.common_util.flow;

import java.util.concurrent.atomic.AtomicLong;


public class FlowControl {
    
	private  AtomicLong count_sec = new AtomicLong(0);
	private  AtomicLong count_min = new AtomicLong(0);
	private  AtomicLong count_hour = new AtomicLong(0);
	private  AtomicLong count_day = new AtomicLong(0);
	
	private long tmpl_sec=System.currentTimeMillis();
	private long tmpl_min=System.currentTimeMillis();
	private long tmpl_hour=System.currentTimeMillis();
	private long tmpl_day=System.currentTimeMillis();
	
	
	
	private final static long LONG_TIME_SEC = 1000;
	private final static long LONG_TIME_MINUTE = LONG_TIME_SEC * 60;
	private final static long LONG_TIME_HOUR = LONG_TIME_MINUTE * 60;
	private final static long LONG_TIME_DAY = LONG_TIME_HOUR * 24;
	
	public enum UNIT{
	    SECOND,
	    MINUTE,
	    HOUR,
	    DAY
	}
	/**
	 * 
	 * @param maxIn 每个时间单位最大流控值
	 * @param unit 时间单位
	 * @param sleep 超流控延时
	 * @return true 超流控
	 */
	public boolean isOverSpeed(int maxIn,UNIT unit,boolean sleep)
	{
	    if(maxIn == -1){
	        return false;
	    }
	    if(unit == UNIT.SECOND){
	        try {
                return isOverSpeedSec(maxIn,sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(unit == UNIT.MINUTE){
            try {
                return isOverSpeedMin(maxIn,sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(unit == UNIT.HOUR){
            try {
                return isOverSpeedHour(maxIn,sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(unit == UNIT.DAY){
            try {
                return isOverSpeedDay(maxIn,sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	    return false;
	  }
	
	
	
	
	
	private boolean isOverSpeedSec(int maxIn,boolean sleep) throws InterruptedException
    {
        if (count_sec.incrementAndGet() >= maxIn)
        {
          long l = System.currentTimeMillis() - tmpl_sec;
          if (l < LONG_TIME_SEC){
              if(sleep){
                  Thread.sleep(LONG_TIME_SEC - l);
                  count_sec = new AtomicLong(1);
                  tmpl_sec = System.currentTimeMillis();
              }
              return true;
          }
          count_sec = new AtomicLong(1);
          tmpl_sec = System.currentTimeMillis();
        }
        return false;
      }
	private boolean isOverSpeedMin(int maxIn,boolean sleep) throws InterruptedException
    {
	    if(sleep) maxIn -= 1;
        if (count_min.incrementAndGet() > maxIn)
        {
          long l = System.currentTimeMillis() - tmpl_min;
          if (l < LONG_TIME_MINUTE){
              if(sleep){
                  Thread.sleep(LONG_TIME_MINUTE - l);
                  count_min = new AtomicLong(1);
                  tmpl_min = System.currentTimeMillis();
              }
              return true;
          }
          count_min = new AtomicLong(1);
          tmpl_min = System.currentTimeMillis();
        }
        return false;
      }
	private boolean isOverSpeedHour(int maxIn,boolean sleep) throws InterruptedException
    {
	    if(sleep) maxIn -= 1;
        if (count_hour.incrementAndGet() > maxIn)
        {
          long l = System.currentTimeMillis() - tmpl_hour;
          if (l < LONG_TIME_HOUR){
              if(sleep){
                  Thread.sleep(LONG_TIME_HOUR - l);
                  count_hour = new AtomicLong(1);
                  tmpl_hour = System.currentTimeMillis();
              }
              return true;
          }
          count_hour = new AtomicLong(1);
          tmpl_hour = System.currentTimeMillis();
        }
        return false;
      }
	private boolean isOverSpeedDay(int maxIn,boolean sleep) throws InterruptedException
    {
	    if(sleep) maxIn -= 1;
        if (count_day.incrementAndGet() > maxIn)
        {
          long l = System.currentTimeMillis() - tmpl_day;
          if (l < LONG_TIME_DAY){
              if(sleep){
                  Thread.sleep(LONG_TIME_DAY - l);
                  count_day = new AtomicLong(1);
                  tmpl_day = System.currentTimeMillis();
              }
              return true;
          }
          count_day = new AtomicLong(1);
          tmpl_day = System.currentTimeMillis();
        }
        return false;
      }
	
	
	
	
	
}
