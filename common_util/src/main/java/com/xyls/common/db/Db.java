package com.xyls.common.db;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Db
{
	private static Logger logger = Logger.getLogger(Db.class);
	
	
	private String LOOKUPNAME;
	public String getLOOKUPNAME() {
		return LOOKUPNAME;
	}
	public void setLOOKUPNAME(String lOOKUPNAME) {
		LOOKUPNAME = lOOKUPNAME;
	}






	private DataSource ds;
	private ThreadLocal<Boolean> rollBackFlag = new ThreadLocal<Boolean>();
	private ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	
	
	
	/**
	 * 可以用来处理增、删、改的方法(连接不关闭)
	 * @throws SQLException 
	 * @sql 相关sql语句
	 * @values 相关的值(sql语句中?部分的值)
	 * @con 数据库连接
	 */
	public void saveOrUpdateOrDelete(String sql,Object values[],Connection con) throws SQLException{
		PreparedStatement stmt=con.prepareStatement(sql);
        if(values!=null){
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i+1,values[i]);
            }
        }
        stmt.execute();
        stmt.close();
	}
	
	/**
	 * 根据给出的SQL进行查询，并将查询结果放到MAP里面，将拼成List返回(连接不关闭)
	 * @sql 相关sql语句
	 * @values 相关的值(sql语句中?部分的值)
	 * @con 数据库连接
	 * @return 查询结果
	 * @throws SQLException 
	 */
	public ArrayList<Map<String,Object>> query(String sql,Object values[],Connection con) throws SQLException{
		ArrayList<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		PreparedStatement stmt=con.prepareStatement(sql);
        if(values!=null){
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i+1,values[i]);
            }
        }
        ResultSet rs=stmt.executeQuery();
        ResultSetMetaData rmd=stmt.getMetaData();
        int columnCount=rmd.getColumnCount();
        while(rs.next()){
            Map<String,Object> map=new HashMap<String,Object>();
            for (int i = 0; i < columnCount; i++) {
                String columnName=rmd.getColumnName(i+1);
                map.put(columnName, rs.getObject(columnName));
            }
            result.add(map);
        }
        rs.close();
        stmt.close();
        return result;
	}
	
	
	
	
	
	/**
	 * 丛数据源配置的连接池(容器连接池)获取连接<br/>
	 * 1. 调用之前务必向LOOKUPNAME附值,如java:/OracleDS_CMGP<br/>
	 * 2. 传入参数标示是否自动提交<br/>
	 * 3. 如果autoCommit为false则需要手动rollBack或者commit<br/>
	 * 4. 连接需要手动关闭(返还连接池)<br/>
	 * 
	 * @return 可用的数据库连接
	 */
	
	public Connection getConnection(boolean autoCommit)
	{
		Connection conn = getConnectionFromPool();
		if(conn == null){
			return null;
		}
		try{
			conn.setAutoCommit(autoCommit);
		}catch(Exception e){
			logger.error(e);
		}
		return conn;
	}
	
	/**
	 * 丛数据源配置的连接池(容器连接池)获取连接<br/>
	 * 1. 调用之前务必向LOOKUPNAME附值,如java:/OracleDS_CMGP<br/>
	 * 2. 从ThreadLocal中获取连接,即同一个线程多次调用此方法都返回同一个连接<br/>
	 * 3. 需要手动提交(autoCommit = false) 以及关闭<br/>
	 * 4. 常用于一个连接事务存在于一个servlet生命周期的情况,filter中提交(回滚)并关闭连接,如<br/>
	 * try{<br/>
			chain.doFilter(srequest, sresponse);<br/>
		}<br/>
		finally
		{<br/>
			DB.commitAndCloseConnection();<br/>
		}<br/>
	 * 
	 * @return 可用的数据库连接
	 */
	public Connection getConnection_TL()
	{
		Connection conn = null;
		conn = (Connection) local.get();
		if (null == conn)
		{
			conn = getConnectionFromPool();
			local.set(conn);
			try{
				conn.setAutoCommit(false);
			}catch(Exception e){
				logger.error(e);
			}
		}
		return conn;
	}
	
	/**
	 * 发生异常时回滚,确保commitAndCloseConnection方法调用时会回滚之前的操作
	 * 
	 */
	public void setRollbackFlag() throws Exception
	{
		rollBackFlag.set(Boolean.TRUE);
	}
	
	
	/**
	 * 提交或回滚并关闭连接,如果之前执行过setRollbackFlag则回滚,否则提交
	 *
	 */
	public void commitAndCloseConnection_TL()
	{
		try
		{
			Connection conn = (Connection) local.get();
			if (null == conn)
			{
				return;
			}
			Boolean flag = (Boolean) rollBackFlag.get();
			if (flag == null || !flag.booleanValue())
			{
				conn.commit();
			}
			else
			{
				conn.rollback();
			}
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		finally
		{
			rollBackFlag.set(null);
			Connection conn = (Connection) local.get();
			if(null != conn)
			{
				try
				{
					conn.close();
				}
				catch (Exception e)
				{
					logger.error(e);
				}
				finally
				{
					local.set(null);
					rollBackFlag.set(null);
				}
			}
		}
	}

	
	
	
	
	
	private Connection getConnectionFromPool(){
		try{
			if (ds == null)
			{
				Context initCtx = new InitialContext();
				ds = (DataSource) initCtx.lookup(LOOKUPNAME);
			}
			Connection conn = ds.getConnection();
			return conn;
		}catch(Exception e){
			logger.error(e);
			return null;
		}
	}
}