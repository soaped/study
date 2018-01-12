package com.xyls.common.commonCache;

public class CacheItem {
	private Object cacheObject;
	private long timeStamp;
	private long expiredTime;
	
	CacheItem(Object obj,long expiredTime) {
		this.cacheObject = obj;
		this.timeStamp = System.currentTimeMillis();
		this.expiredTime = expiredTime;
	}

	Object getCacheObject() {
		return cacheObject;
	}

	long getTimeStamp() {
		return timeStamp;
	}
    
    long getExpiredTime() {
    
        return expiredTime;
    }

}
