package com.xyls.common_util.file;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Stack;
import java.util.zip.*;

public class ArchiveUtil {


	private static Logger logger = Logger.getLogger(ArchiveUtil.class);


	/**
	 *  压缩文件到当前目录
	 * @param srcPathName
	 */
	public static void compressFile(String srcPathName) {
		File srcdir = new File(srcPathName);
		if (!srcdir.exists()){
			throw new RuntimeException(srcPathName + "不存在！");
		}

		Project prj = new Project();
		Zip zip = new Zip();
		zip.setProject(prj);
		zip.setDestFile(new File(srcPathName + ".zip"));
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		zip.addFileset(fileSet);
		zip.execute();
	}


	
/**
* gzip压缩单个文件
* 
* @from 待压缩的文件
* @to 压缩后的文件
*/
public static void gzipFile(String from, String to) {
   FileInputStream in = null;
   GZIPOutputStream out = null;
   try {
	   in = new FileInputStream(from);
	   out = new GZIPOutputStream(new FileOutputStream(to));
	   byte[] buffer = new byte[2048];
	   int bytes_read;
	   while ((bytes_read = in.read(buffer)) != -1) {
		   out.write(buffer, 0, bytes_read);
	   }
   }catch (Exception e) {
	   logger.error(e);
   }finally {
	   try{
		   in.close();
		   out.close();
	   }catch(Exception e){
		   logger.error(e);
	   }
   }

}
//public static void main(String []args){
//	for(String name:new File("D:\\182\\").list()){
//		ArchiveUtil.unGzipFile("D:\\182\\"+name, "D:\\182t\\"+name.substring(0,name.lastIndexOf(".")));
//		System.out.println(name);
//	}
//}
/**
* gzip解压缩单个文件
* 
* @from 待解压的文件
* @to 解压后的文件
*/
public static void unGzipFile(String from, String to){
	GZIPInputStream in = null;
	FileOutputStream out = null;
   try {
	   in = new GZIPInputStream(new FileInputStream(from));
	   out = new FileOutputStream(to);
	   byte[] buffer = new byte[2048];
	   int bytes_read;
	   while ((bytes_read = in.read(buffer)) != -1) {
	     out.write(buffer, 0, bytes_read);
	   }
   }catch (Exception e) {
	   logger.error(e);
   } finally {
	   try{
		   in.close();
		   out.close();
	   }catch(Exception e){
		   logger.error(e);
	   }
   }

}

/**
* zip解压缩
* 
* @srcInputStream 压缩文件路径
* @destDir 解压的目标目录
*/
public static void zipDecompression(String srcFile, String destDir)
   {
	try{
	   FileInputStream srcInputStream = new FileInputStream(new File(srcFile));
	   ZipInputStream zipStream = new ZipInputStream(srcInputStream);
	   ZipEntry entry;
	
	   File destFile = new File(destDir);
	   if (!destFile.exists()) {
	    destFile.mkdir();
	   }
	
	   FileOutputStream entryOutputStream;
	   byte buff[] = new byte[256];
	   int len;
	   while ((entry = zipStream.getNextEntry()) != null) {
	    String entryName = destDir + File.separator + entry.getName();
	    if (!entry.isDirectory()) {
	     File file = new File(entryName);
	     File dir = file.getParentFile();
	     if (!dir.exists()) {
	      dir.mkdir();
	     }
	     entryOutputStream = new FileOutputStream(file);
	     while ((len = zipStream.read(buff)) > 0) {
	      entryOutputStream.write(buff, 0, len);
	     }
	     entryOutputStream.flush();
	     entryOutputStream.close();
	    } else {
	     File file = new File(entryName);
	     File dir = file.getParentFile();
	     if (!dir.exists()) {
	      dir.mkdir();
	     }
	     file.mkdir();
	    }
	   }
	   zipStream.close();
	   srcInputStream.close();
	}catch(Exception e){
		logger.error(e);
	}
}

/**
* zip压缩文件
* 
* @srcFile 待压缩的文件或者目录
* @destFile 压缩的目标目录
*/
public static void zipCompression(String srcFile, String destFile,boolean zipOutDir)
    {
	try{
	   FileOutputStream destFileOutputStream = new FileOutputStream(destFile);
	   ZipOutputStream zipOutputStream = new ZipOutputStream(destFileOutputStream);
	   Stack<File> stack = new Stack<File>();
	   File listFiles[];
	   FileInputStream currentFileInputStream;
	   int len;
	   byte[] buff = new byte[256];
	   File currentFile = new File(srcFile);
	   int relativelyPosition = currentFile.getAbsolutePath().lastIndexOf(
	     File.separator) + 1+(zipOutDir?0:(currentFile.getAbsolutePath().length() - currentFile.getAbsolutePath().lastIndexOf(File.separator)));;
	   stack.push(currentFile);
	   while (!stack.isEmpty()) {
	    currentFile = stack.pop();
	    if (currentFile.isDirectory()) {
	     listFiles = currentFile.listFiles();
	     for (File file : listFiles) {
	      stack.push(file);
	     }
	    } else {
	     zipOutputStream.putNextEntry(new ZipEntry(currentFile
	       .getAbsolutePath().substring(relativelyPosition)));
	     currentFileInputStream = new FileInputStream(currentFile);
	     while ((len = currentFileInputStream.read(buff)) > 0) {
	      zipOutputStream.write(buff, 0, len);
	     }
	     currentFileInputStream.close();
	    }
	   }
	   zipOutputStream.finish();
	   zipOutputStream.close();
	   destFileOutputStream.flush();
	   destFileOutputStream.close();
	}catch(Exception e){
		logger.error(e);
	}
}
}
