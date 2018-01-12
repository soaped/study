package com.xyls.common.file;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);



	/**
	 * 获取文件的引用,ClassPath中能够找到即可,避免了绝对路径
	 * @param filename 文件名称
	 */
	public static File getFileFromClassPath(String filename){
		ClassLoader  loader  =  Thread.currentThread().getContextClassLoader(); 
		URL url = loader.getResource(filename);
		if(url != null){
		    String path = url.getFile();
		    if(path != null){
		        return new File(path);
		    }
		}
		return null;
	}
	
	/**
	 * 从classPath中获取文件内容
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String getContentFromClassPath(String path) throws IOException{
        ClassLoader  loader  =  Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(path);
        InputStream is =url.openStream();
        return IOUtils.toString(is, "UTF-8");
    }

	/**
	 * (递归)创建目录
	 *
	 * @folderPath 待创建目录的路径
	 */
	public static void newFolder(String folderPath) {
		try {
			File myFilePath = new File(folderPath);
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
			}
		}
		catch (Exception e) {
			logger.error(e);
		}
	}


	/**
	 * 创建文件<br>
	 * 1. 如果目录不存在则递归创建<br>
	 * 2. 如果文件已存在则覆盖内容<br>
	 * @filePathAndName 待创建文件的路径
	 * @fileContent 文件内容(为null则创建空文件或清空已存在的文件)
	 */
	public static void newFile(String filePathAndName, String fileContent, String csn) {
		String dir = null;
		if(filePathAndName.indexOf(File.separator) != -1){
			dir = filePathAndName.substring(0,filePathAndName.lastIndexOf(File.separator));
		}
		if(filePathAndName.indexOf("//") != -1){
			dir = filePathAndName.substring(0,filePathAndName.lastIndexOf("//"));
		}

		newFolder(dir);
		try {
			File myFilePath = new File(filePathAndName);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}else{
				if(fileContent == null){
					myFilePath.delete();
					myFilePath.createNewFile();
				}
			}
			if(fileContent != null){
//				FileWriter resultFile = new FileWriter(myFilePath);
//				PrintWriter myFile = new PrintWriter(resultFile);
                PrintWriter myFile = new PrintWriter(myFilePath,csn);

				myFile.println(fileContent);
//                resultFile.close();
                myFile.close();
			}
		}
		catch (Exception e) {
			logger.error(e);
		}
	}

	/**
     * 创建文件<br>
     * 1. 如果目录不存在则递归创建<br>
     * 2. 如果文件已存在则覆盖内容<br>
     * @filePathAndName 待创建文件的路径
     * @fileContent 文件内容(为null则创建空文件或清空已存在的文件)
     */
    public static void newFile(String filePathAndName, byte[] fileContent) {
        String dir = null;
        if(filePathAndName.indexOf(File.separator) != -1){
            dir = filePathAndName.substring(0,filePathAndName.lastIndexOf(File.separator));
        }
        if(filePathAndName.indexOf("//") != -1){
            dir = filePathAndName.substring(0,filePathAndName.lastIndexOf("//"));
        }

        newFolder(dir);
        try {
            File myFilePath = new File(filePathAndName);
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }else{
                if(fileContent == null){
                    myFilePath.delete();
                    myFilePath.createNewFile();
                }
            }
            if(fileContent != null){
                FileOutputStream fos = new FileOutputStream(myFilePath);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                bos.write(fileContent);
                bos.close();
                fos.close();
            }
        }
        catch (Exception e) {
            logger.error(e);
        }
    }


	/**
	 * 删除文件或目录<br/>
	 * 1. 如果参数路径为目录,则会递归删除目录中的所有文件<br/>
	 * 2. 如果参数路径不存在,则直接返回<br/>
	 *
	 * @path 待删除的文件或者目录的路径
	 * @delDir 是否删除最外层目录
	 */
	public static void delFile(String path,boolean delDir) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			File myDelFile = new File(path);
			myDelFile.delete();
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			}else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if(temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delFile(path+"/"+ tempList[i],true);
				File folder = new File(path+"/"+ tempList[i]);
				folder.delete();
			}
		}
		if(delDir){
			File folder = new File(path);
			folder.delete();
		}
	}







	/**
	 * 复制文件或目录<br/>
	 * 1. 源路径为文件<br/>
	 * (1) 目的路径为文件,则相当于复制后重命名(如果目的路径的文件已存在则覆盖)<br/>
	 * (2) 目的路径为目录,则复制到目的路径下<br/>
	 * 2. 源文件为目录<br/>
	 * 	(1) 目的路径为文件则返回<br/>
	 * 	(2) 目睹路径文目录(没有则递归创建),则递归复制<br/>
	 * @oldPath 待复制的文件或者目录
	 * @newPath 目的文件或者目录
	 */
	public static void copyFile(String oldPath, String newPath){
		try{
			File a=new File(oldPath);
			if(!a.isDirectory()){
				File oldfile = new File(oldPath);
				if (oldfile.exists()){
					int byteread = 0;
					InputStream inStream = new FileInputStream(oldPath);
					FileOutputStream  fs = null;
					if(new File(newPath).isDirectory()){
						fs = new FileOutputStream(newPath+File.separator+a.getName());
					}else{
						fs = new FileOutputStream(newPath);
					}
					byte[] buffer = new byte[1444];
//					int bytesum = 0;
					while ((byteread = inStream.read(buffer)) != -1) {
//						bytesum += byteread;
						fs.write(buffer, 0, byteread);
					}
					inStream.close();
					fs.close();
					return;
				}else{
					return;
				}
			}
			if((new File(newPath)).exists() && !(new File(newPath)).isDirectory()){
				return;
			}
			new File(newPath).mkdirs();
			String[] file=a.list();
			File temp=null;
			for(int i = 0; i < file.length; i++){
				if(oldPath.endsWith(File.separator)){
					temp=new File(oldPath+file[i]);
				}else{
					temp=new File(oldPath+File.separator+file[i]);
				}
				if(temp.isFile()){
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ( (len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if(temp.isDirectory()){
					copyFile(oldPath+"/"+file[i],newPath+"/"+file[i]);
				}
			}
		}
		catch (Exception e){
			logger.error(e);
		}
	}

	private static final int BUFFER_SIZE = 16 * 1024;
	/**
	 * 复制文件<br/>
	 * @src 源文件
	 * @dst 目标文件
	 */
	public static void copy(File src, File dst) {
        try {
           InputStream in = null ;
           OutputStream out = null ;
            try {
               in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
               out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                byte [] buffer = new byte [BUFFER_SIZE];
                while (in.read(buffer) > 0 ) {
                   out.write(buffer);
               }
           } finally {
                if ( null != in) {
                   in.close();
               }
                if ( null != out) {
                   out.close();
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


	/**
	 * 向文件追加内容<br/>
	 * 1. 如果文件不存在则新建立文件<br/>
	 * 2. 目录不存在则递归建立目录<br/>
	 * @filePathAndName 待追加的文件的路径
	 * @content 追加的文字
	 */
	public static void appendFile(String filePathAndName, String content){
		   try {
			   File a=new File(filePathAndName);
			   if(!a.exists()){
				   String dir = null;
				   if(filePathAndName.indexOf(File.separator) != -1){
					   dir = filePathAndName.substring(0,filePathAndName.lastIndexOf(File.separator));
				   }
				   if(filePathAndName.indexOf("//") != -1){
					   dir = filePathAndName.substring(0,filePathAndName.lastIndexOf("//"));
				   }
				   (new File(dir)).mkdirs();
			   }
			   FileWriter writer = new FileWriter(filePathAndName, true);
			   writer.write(content);
			   writer.close();
		   	}catch (Exception e) {
		   		logger.error(e);
		   	}
	}













    /**
     *  获取文件有效行数(忽略空行)
     * @param fileName
     * @param skipstart
     * @param skipend
     * @return
     */
    public static int readLinesCount(String fileName,String skipstart,String skipend) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String tempString = null;
            int line = 0;
            boolean skip = false;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	if(StringUtils.isEmpty(tempString)||tempString.trim().equals(""))continue;

            	if(skipstart != null && tempString.trim().startsWith(skipstart)){
            		skip = true;
            	}
            	if(skipend != null && tempString.trim().endsWith(skipend)){
            		skip = false;
            		continue;
            	}
            	if(skip) continue;
                line++;
            }
            reader.close();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return 0;
    }


    /**
     * 以行为单位读取文件，(忽略空行)
     */
    public static String readFileContent(String fileName) {
        try {
            return readFileContent(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
        }
        return null;
    }
    /**
     * 以行为单位读取文件，(忽略空行)
     */
    public static String readFileContent(InputStream is) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String tempString = null;
            StringBuffer content = new StringBuffer();
            boolean start = true;
            while ((tempString = reader.readLine()) != null) {
            	if(StringUtils.isEmpty(tempString)||tempString.trim().equals(""))continue;
            	if(start){
            		start = false;
            	}else{
            		content.append("\r\n");
            	}
            	content.append(tempString);
            }
            reader.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return null;
    }



    /**
     * 读取文件制定行，(忽略空行，第一行为1)
     */
    public static String readFileByLines(String fileName,int lineNumber,String skipstart,String skipend) {
    	if(lineNumber <= 0) return null;
         BufferedReader reader = null;
         try {
             reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
             String tempString = null;
             int line = 0;
             boolean skip = false;
             while ((tempString = reader.readLine()) != null) {
             	if(StringUtils.isEmpty(tempString)||tempString.trim().equals(""))continue;

             	if(skipstart != null && tempString.trim().startsWith(skipstart)){
            		skip = true;
            	}
            	if(skipend != null && tempString.trim().endsWith(skipend)){
            		skip = false;
            		continue;
            	}
            	if(skip) continue;

                 line++;

                 if(lineNumber == line){
                	 reader.close();
                	 return tempString;
                 }
             }
             reader.close();
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             if (reader != null) {
                 try {
                     reader.close();
                 } catch (IOException e1) {
                 }
             }
         }
         return null;
    }



    /**
     * 获取文件字节流
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] getBytesFromFile(File file) throws IOException {
        byte[] buffer = null;
        if(!file.exists()){
            return null;
        }
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
        byte[] b = new byte[1024];  
        int n;  
        while ((n = fis.read(b)) != -1) {  
            bos.write(b, 0, n);  
        }  
        fis.close();  
        bos.close();  
        buffer = bos.toByteArray();
        
        return buffer;
    }

	public static void writeFileToDisk(byte[] byteFile, String filePathAnaName) throws IOException {
		File file = new File(filePathAnaName);
		FileOutputStream fops = new FileOutputStream(file);
		fops.write(byteFile);
		fops.flush();
		fops.close();
	}
	public static byte[] getFileByteArrayFromNetByUrl(String strUrl, String requestMethod) throws Exception {
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod(requestMethod);
		conn.setConnectTimeout(5 * 1000);
		InputStream inStream = conn.getInputStream();
		byte[] byteFile = readInputStream(inStream);
		return byteFile;
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = inStream.read(buffer)) > 0){
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}