package com.yangfuzhao.common.log;

import org.apache.log4j.Logger;

import java.util.Calendar;


public class TimerPrintLogger {
    

    private Logger logger;
    
    public TimerPrintLogger(final Logger logger, final String timerInfo){
        this.logger = logger;
        Thread timerThread = new Thread(){
            public void run(){
                while(true){
                    try {
                        sleep(getSleepMillis());
                        logger.debug(timerInfo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
            }
        };
        timerThread.setDaemon(true);
        timerThread.start();
    }
    
    
    private long getSleepMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTimeInMillis() - System.currentTimeMillis();
    }
    
    public Logger getLogger(){
        return logger;
    }
}
