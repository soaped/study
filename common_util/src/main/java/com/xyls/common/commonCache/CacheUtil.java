package com.xyls.common.commonCache;

import org.apache.commons.collections4.map.LRUMap;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Map;


public class CacheUtil {
    
    private static Logger logger = Logger.getLogger(CacheUtil.class);
    
    private int cacheSize = 10000;
    
    private Map<String,Object> cache = null;
    
    public CacheUtil(int cacheSizeIn) {
        cacheSize = cacheSizeIn;
        cache = Collections.synchronizedMap(new LRUMap<String, Object>(cacheSize));
    }
    
    public CacheUtil() {
        cache = Collections.synchronizedMap(new LRUMap<String, Object>(cacheSize));
    }

    public boolean put(String key, Object value,long expireTime) {
        try {
            cache.put(key, new CacheItem(value,expireTime));
            return true;
        } catch (Exception e) {
            logger.error("cache " + key + "put failed");
            return false;
        }
    }

    public Object get(String key) {
        Object obj = cache.get(key);
        if (obj == null) {
            return null;
        }
        CacheItem cacheItem = (CacheItem) obj;
        if((System.currentTimeMillis() - cacheItem
                .getTimeStamp()) > cacheItem.getExpiredTime()){
            logger.debug("cacheItem expired, key:"+ key);
            return null;
        }
        logger.debug("cache " + key + " hit.");
        return cacheItem.getCacheObject();

    }
    public void remove(Object key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }
    
    
    
    
    
    public static void main(String [] args){
        CacheUtil cache = new CacheUtil(3);
        cache.put("1", 1,2000);
        cache.put("2", 2,2000);
        cache.put("3", 3,2000);
        cache.put("4", 4,2000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
        }
        System.out.println(cache.get("1"));
        System.out.println(cache.get("2"));
        System.out.println(cache.get("3"));
        System.out.println(cache.get("4"));
        
    }
}
