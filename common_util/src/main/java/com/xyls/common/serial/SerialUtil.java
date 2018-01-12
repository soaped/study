package com.xyls.common.serial;

import com.xyls.common.file.FileUtil;
import org.apache.log4j.Logger;

import java.io.*;


public class SerialUtil{
	
	private static Logger logger = Logger.getLogger(SerialUtil.class);
	
	
	/**
	 * 可序列化的对象保存为文件
	 * @serial 实现了 Serializable 接口的类的对象
	 * @path 所保存为文件的路径
	 */
	public static void ObjectToFileSystem(Serializable serial,String path){
	    if(!new File(path).exists()){
	        FileUtil.newFile(path, "".getBytes());
	    }
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(path);  
			ObjectToOutputStream(serial,fos);
		}catch(Exception e){
			logger.error(e);
		}finally{
			if(fos != null){
				try{
					fos.close();
					fos = null;
				}catch(Exception e){
					logger.error(e);
				}
			}
		}
	}
	/**
	 * 可序列化的对象序列化为Os流
	 * @serial 实现了 Serializable 接口的类的对象
	 * @out 所序列化的os的流
	 */
	public static void ObjectToOutputStream(Serializable serial,OutputStream out){
		ObjectOutputStream oos = null;
		try{
			oos = new ObjectOutputStream(out);
			oos.writeObject(serial);               
			oos.flush();
			oos.close();
		}catch(Exception e){
			logger.error(e);
		}finally{
			if(out != null){
				try{
					out.close();
					out = null;
				}catch(Exception e){
					logger.error(e);
				}
			}
			if(oos != null){
				try{
					oos.close();
					oos = null;
				}catch(Exception e){
					logger.error(e);
				}
			}
		}
	}
	/**
	 * is 流反序列化为可序列化的对象
	 * @in 待反序列化的 is流 
	 * @return 可序列化的对象
	 */
	public static Serializable InputStreamToObject(InputStream in){
		ObjectInputStream iin = null;
		try{
			iin = new ObjectInputStream(in);
			Serializable obj = (Serializable)iin.readObject();
			iin.close();
		return obj;
		}catch(Exception e){
			logger.error(e);
			return null;
		}finally{
			if(in != null){
				try{
					in.close();
					in = null;
				}catch(Exception e){
					logger.error(e);
				}
			}
			if(iin != null){
				try{
					iin.close();
					iin = null;
				}catch(Exception e){
					logger.error(e);
				}
			}
		}
	}
	/**
	 * 文件系统的文件反序列化为可序列化的对象
	 * @paht 待反序列化的文件路径 
	 * @return 可序列化的对象
	 */
	public static Serializable FileSystemToObject(String path){
	    if(!new File(path).exists()){
	        return null;
	    }
		InputStream in = null;
		try{
			in = new FileInputStream(path);
			return InputStreamToObject(in);
		}catch(Exception e){
			return null;
		}finally{
			if(in != null){
				try{
					in.close();
					in = null;
				}catch(Exception e){
					logger.error(e);
				}
			}
		}
	}
}