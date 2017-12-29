package com.yangfuzhao.common.db;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;


public class DBConnectionManager {
	
	
  private static Logger logger = Logger.getLogger(DBConnectionManager.class);

  /**
   * 
   * @param dsPropertiePath 相对classpath的配置文件路径
   * 
   * 数据格式如下<br/><br/>
   * 
   * drivers=oracle.jdbc.driver.OracleDriver com.mysql.jdbc.Driver<br/>
   * <br/>
   * oracle.url=jdbc:oracle:thin:@218.206.69.46:1522:asptstdb<br/>
   * oracle.user=ecconf<br/>
   * oracle.password=ecconf<br/>
   * oracle.maxconn=2<br/>
   * mysql.url=jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding =gbk<br/>
   * mysql.user=root<br/>
   * mysql.password=<br/>
   * mysql.maxconn=25<br/><br/>
   * 
   * .前面的是数据源名称
   */
  
  public DBConnectionManager(String dsPropertiePath){
      initialize(dsPropertiePath);
  }
  



  private Vector<Driver> drivers = new Vector<Driver>();
  private Hashtable<String,DBConnectionPool> pools = new Hashtable<String,DBConnectionPool>();
  private void initialize(String dsPropertiePath){
	  Properties props = new Properties();
	  try {
	      ClassLoader  loader  =  Thread.currentThread().getContextClassLoader(); 
	      props.load(loader.getResource(dsPropertiePath).openStream());
	  }catch (IOException e) {
	      logger.error("请确保DsPropertiePath附值正确"+e);
	      return;
	  }
	  
	  
	  String driverClasses = props.getProperty("drivers");
	  StringTokenizer st = new StringTokenizer(driverClasses);
	  while (st.hasMoreElements()) {
	      String driverClassName = st.nextToken().trim();
	      try {
	        Driver driver = (Driver)
	            Class.forName(driverClassName).newInstance();
	        DriverManager.registerDriver(driver);
	        drivers.addElement(driver);
	      }     
	      catch (Exception e) {
	        logger.error("无法注册JDBC驱动程序: " +driverClassName + ", 错误: " + e);
	      }
	  }
	    
	  Enumeration<?> propNames = props.propertyNames();
	  while (propNames.hasMoreElements()) {
	      String name = (String) propNames.nextElement();
	      if (name.endsWith(".url")) {
	        String poolName = name.substring(0, name.lastIndexOf("."));
	        String url = props.getProperty(poolName + ".url");
	        if (url == null) {
	        	logger.error("没有为连接池" + poolName + "指定URL");
	        	continue;
	        }
	        String user = props.getProperty(poolName + ".user");
	        String password = props.getProperty(poolName + ".password");
	        String maxconn = props.getProperty(poolName + ".maxconn", "0");
	        int max;
	        try {
	          max = Integer.valueOf(maxconn).intValue();
	        }
	        catch (NumberFormatException e) {
	        	logger.error("错误的最大连接数限制: " + maxconn + " .连接池: " + poolName);
	          max = 0;
	        }
	        DBConnectionPool pool =
	            new DBConnectionPool(poolName, url, user, password, max);
	        pools.put(poolName, pool);
	      }
	  }
  }
  
  
  
  
  
  
  
  
  /**
   * 释放相关数据源的连接
   * @name 所释放连接的数据源
   * @con 所释放的连接
   */
  public void freeConnection(String name, Connection con) {
	  if(con == null){
		  return;//这个con get的时候可能返回null
	  }
    DBConnectionPool pool = (DBConnectionPool) pools.get(name);
    if (pool != null) {
      pool.freeConnection(con);
    }
  }

  /**
   * 获得一个可用连接<br/>
   * 1. 如果没有可用连接,且已有连接数小于最大连接数,则创建并返回新连接<br/>
   * 2. 如果没有可用连接,且已有连接数等于于最大连接数,则返回null<br/>
   * @name 获取连接的数据源
   * @return Connection 可用的连接
   */
  public Connection getConnection(String name) {
    DBConnectionPool pool = (DBConnectionPool) pools.get(name);
    if (pool != null) {
      return pool.getConnection();
    }
    return null;
  }

  /**
   * 获得一个可用连接<br/>
   * 1. 如果没有可用连接,且已有连接数小于最大连接数,则创建并返回新连接<br/>
   * 2. 如果没有可用连接,且已有连接数等于于最大连接数,则在指定时间内等待其他线程释放可用连接,如果time内依然没有可用连接,则返回null<br/>
   * @name 获取连接的数据源
   * @time 当已用连接数等于于最大连接数时等待其他线程释放可用连接的时间
   * @return Connection 可用的连接
   */
  public Connection getConnection(String name, long time) {
    DBConnectionPool pool = (DBConnectionPool) pools.get(name);
    if (pool != null) {
      return pool.getConnection(time);
    }
    return null;
  }

  /**
   * 
   * 并关闭所有数据源的空闲连接<br/>
   * 如果存在还没Free到池的连接,日志中会给出提示
   * 
   */
public synchronized void release() {
    Enumeration<DBConnectionPool> allPools = pools.elements();
    while (allPools.hasMoreElements()) {
      DBConnectionPool pool = (DBConnectionPool) allPools.nextElement();
      pool.release();
    }
    Enumeration<Driver> allDrivers = drivers.elements();
    while (allDrivers.hasMoreElements()) {
      Driver driver = (Driver) allDrivers.nextElement();
      try {
        DriverManager.deregisterDriver(driver);
      }
      catch (SQLException e) {
    	  logger.error("无法撤销下列JDBC驱动程序的注册: " + driver.getClass().getName()+" " + e);
      }
    }
  }
  
  /**
   * 返回相关数据源对应的连接数峰值
   * 
   * @name 数据源名称
   * @return 相关数据源对应的连接数峰值
   */
  public int getUpConn(String name) {
	    DBConnectionPool pool = (DBConnectionPool) pools.get(name);
	    if(pool == null){
	    	return 0;
	    }
	    return pool.UpConn;
  }
  

  
  
  
  
  
  
  
  class DBConnectionPool {
    private int checkedOut;
    private Vector<Connection> freeConnections = new Vector<Connection>();
    private int maxConn;
    private String name;
    private String password;
    private String URL;
    private String user;

    private int UpConn; //连接数峰值
    
    private DBConnectionPool(String name, String URL, String user,
                            String password,
                            int maxConn) {
      this.name = name;
      this.URL = URL;
      this.user = user;
      this.password = password;
      this.maxConn = maxConn;
    }

    
    
    private synchronized void freeConnection(Connection con) {
      freeConnections.addElement(con);
      checkedOut--;
      notifyAll();
    }


    private synchronized Connection getConnection() {
      Connection con = null;
           
      if (freeConnections.size() > 0) {
        con = (Connection) freeConnections.firstElement();
        freeConnections.removeElementAt(0);
        try {
        	//也可以select * from dual 判定连接可用性
          if (con.isClosed()) {
            //递归调用自己,尝试再次获取可用连接
            con = getConnection();
          }
        }
        catch (SQLException e) {
          //递归调用自己,尝试再次获取可用连接
          con = getConnection();
        }
      }
      else if (maxConn == 0 || checkedOut < maxConn) {
        con = newConnection();
        
      }
      if (con != null) {
        checkedOut++;
        if(checkedOut > UpConn){
        	UpConn = checkedOut; 
        }
      }
      return con;
    }

    private synchronized Connection getConnection(long timeout) {
      long startTime = new Date().getTime();
      Connection con;
      while ( (con = getConnection()) == null) {
        try {
          wait(timeout);
        }
        catch (InterruptedException e) {
        	logger.error(e);
        }
        if ( (new Date().getTime() - startTime) >= timeout) {
        	//wait()返回的原因是超时
          return null;
        }
      }
      return con;
    }

	private synchronized void release() {
      if(checkedOut != 0){
    	  logger.warn("数据源"+name +" release时存在"+checkedOut + "个没有free的连接");
      }
      Enumeration<Connection> allConnections = freeConnections.elements();
      while (allConnections.hasMoreElements()) {
        Connection con = (Connection) allConnections.nextElement();
        try {
          con.close();
        }
        catch (SQLException e) {
        	logger.error(e + "无法关闭连接池" + name + "中的空闲连接");
        }
      }
      freeConnections.removeAllElements();
    }

    /**
     * 创建新的连接
     /**/
     private Connection newConnection() {
       Connection con = null;
       try {
       	
         if (user == null) 
         {
           con = DriverManager.getConnection(URL);
         }
         else 
         {
         	con = DriverManager.getConnection(URL, user, password);
         }
      }
       catch (Exception e) {
    	   logger.error(e + "无法从连接池"+ name +"取得新连接");
       }
     return con;
     }
  }
}
