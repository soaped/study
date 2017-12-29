package com.yangfuzhao.common.constant;


import com.ipaynow.npacc.common.file.FileUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConstantConfig {
	
	
	private static Map<String,Properties> propertiesMap = new HashMap<String,Properties>();
	private static Map<String,String> contentMap = new HashMap<String,String>();
	
	private static final ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	private static final int REGETSEC = 15;
	
	static{
		Thread t = new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(REGETSEC * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					rwl.writeLock().lock();
					propertiesMap.clear();
					contentMap.clear();
					rwl.writeLock().unlock();	
				}
			}
		};
		t.setDaemon(true);
		t.start();
	}
	
	/**
     * 获取classPath下 properties
     * @param path classPath下资源文件的相对路径
     * @return
     */
	public static Properties getProperties(String path){
		try{
			rwl.readLock().lock();
			if(propertiesMap.get(path) == null){
	            Properties properties = new Properties();
	            ClassLoader  loader  =  Thread.currentThread().getContextClassLoader(); 
	            properties.load(new InputStreamReader(loader.getResourceAsStream(path), "UTF-8"));
	            propertiesMap.put(path, properties);
	        }
	        return propertiesMap.get(path);
		}catch(IOException e){
			return null;
		}finally{
			rwl.readLock().unlock();
		}
    }
	
	/**
	 * 获取classPath下 properties资源文件的value
	 * @param path classPath下资源文件的相对路径
	 * @param key 资源文件的key
	 * @return
	 */
    public static String getPropertiesValue(String path,String key){
    	Properties properties = getProperties(path);
    	if(properties == null)return null;
    	return properties.getProperty(key);
    }
	
    
    /**
     * 获取classPath下 资源文件的内容
     * @param path classPath下资源文件的相对路径
     * @return
     */
    public static String getContentValue(String path){
    	try{
			rwl.readLock().lock();
			if(contentMap.get(path) == null){
				contentMap.put(path, FileUtil.getContentFromClassPath(path));
	        }
	        return contentMap.get(path);
		}catch(IOException e){
			return null;
		}finally{
			rwl.readLock().unlock();
		}
    }
    
}
