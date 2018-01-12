/**
 *
 */

package com.xyls.common.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import java.io.*;


public class FtpUtil {

	private static Logger logger = Logger.getLogger(FtpUtil.class);

	/**
	 * 操作成功
	 */
	public final static int OPERATE_SUCCEED = 0;
	/**
	 * 操作失败
	 */
	public final static int OPERATE_FAIL = 1;


	private FTPClient fClient;





    private String hostName;
    private String userName;
    private String passWord;
    private int timeOut;

    public FtpUtil(String hostName, String userName, String passWord, int timeOut){
        this.hostName = hostName;
        this.userName = userName;
        this.passWord = passWord;
        this.timeOut = timeOut;
    }



	/**
	 * 与ftp服务器建立连接
	 *
	 * @hostName  主机IP
	 * @userName  用户名
	 * @passWord  密码
	 * @timeOut  超时时间
	 * @return int FTPUtils.OPERATE_SUCCEED 或者 FTPUtils.OPERATE_FAIL
	 */
	public int connect() {
		fClient = new FTPClient();

		try {
			fClient.connect(hostName);
			fClient.login(userName, passWord);
			fClient.setSoTimeout(timeOut);
			fClient.setFileTransferMode(FTPClient.STREAM_TRANSFER_MODE);
			fClient.setFileType(FTPClient.BINARY_FILE_TYPE);

			//fClient.enterLocalActiveMode();
			fClient.enterLocalPassiveMode();
			return OPERATE_SUCCEED;
		} catch (IOException ex) {
			logger.error(ex);
			return OPERATE_FAIL;
		}
	}

	/**
	 * 本地指定路径的文件上传到服务器上
	 *
	 * @remotePath 服务器上文件路径
	 * @localPath 本地路径
	 * @hostName  主机IP
	 * @userName  用户名
	 * @passWord  密码
	 * @timeOut  超时时间
	 * @return int FTPUtils.OPERATE_SUCCEED 或者 FTPUtils.OPERATE_FAIL
	 */
	public int upLocalFileToFTP(String remotePath, String localPath){
		int ret = threeCon(hostName, userName, passWord, timeOut);
		if (OPERATE_FAIL == ret) {
			return OPERATE_FAIL;
		}

		InputStream is = null;
		try {
			is = new FileInputStream(localPath);
			if (fClient.storeFile(remotePath, is)) {
				return OPERATE_SUCCEED;
			}
		}catch(Exception e){
			logger.error(e);
		}finally {
			if (null != is) {
				try{
					is.close();
				}
				catch(Exception e){
					logger.error(e);
				}
			}
		}
		return OPERATE_FAIL;
	}

	/**
	 * 将服务器上指路径的文件下载到本地
	 *
	 * @remotePath 服务器上文件路径
	 * @localPath 本地路径
	 * @hostName  主机IP
	 * @userName  用户名
	 * @passWord  密码
	 * @timeOut  超时时间
	 * @return int FTPUtils.OPERATE_SUCCEED 或者 FTPUtils.OPERATE_FAIL
	 */
	public int downFtpFileToLoad(String remotePath, String localPath)
	{
		// 如果连接断了,自动重连
		int ret = threeCon(hostName, userName, passWord, timeOut);
		if (OPERATE_FAIL == ret) {
			return OPERATE_FAIL;
		}
		OutputStream os = null;
		try {
			// 如果保存在本地的文件不存在则自动创建
			File file = new File(localPath);
			File dirs = file.getParentFile();
			if (!dirs.exists()) {
				dirs.mkdirs();
			}
			os = new FileOutputStream(file);
			// 判断ftp服务器上的文件下载到本地是否成功
			if (fClient.retrieveFile(remotePath, os)) {
				return OPERATE_SUCCEED;
			}
		}catch(Exception e){
			logger.error(e);
		}finally {
			if (null != os) {
				try{
					os.flush();
					os.close();
				}catch(Exception e){
					logger.error(e);
				}
			}
		}
		return OPERATE_FAIL;
	}

	/**
	 * 删除服务器上指定路径的文件
	 *
	 * @remotePath 服务器上文件路径
	 * @hostName  主机IP
	 * @userName  用户名
	 * @passWord  密码
	 * @timeOut  超时时间
	 * @return int FTPUtils.OPERATE_SUCCEED 或者 FTPUtils.OPERATE_FAIL
	 */
	public int deleteFtpFile(String remotePath)
	{
		int ret = threeCon(hostName, userName, passWord, timeOut);
		if (OPERATE_FAIL == ret) {
			return OPERATE_FAIL;
		}
		try{
			if (fClient.deleteFile(remotePath)) {
				return OPERATE_SUCCEED;
			}
		}catch(Exception e){
			logger.error(e);
			return OPERATE_FAIL;
		}
		return OPERATE_FAIL;
	}

	/**
	 * 获取服务器上指定路径的文件名称列表
	 *
	 * @remotePath 服务器上文件路径
	 * @hostName  主机IP
	 * @userName  用户名
	 * @passWord  密码
	 * @timeOut  超时时间
	 *
	 * @return String[] 文件名称列表
	 */
	public String[] getFileNameList(String remotePath){
		String[] fileNames = null;
		int ret = threeCon(hostName, userName, passWord, timeOut);
		if (OPERATE_FAIL == ret) {
			return fileNames;
		}
		try{
			fileNames = fClient.listNames(remotePath);
		}catch(Exception e){
			logger.error(e);
		}
		return fileNames;
	}

	/**
	 * FTP上创建目录
	 * @pathName 创建目录路径
	 */
	public void makeDirectory(String pathName) {
		if (null != pathName && !"".equals(pathName))
		{
			try{
				if (!fClient.makeDirectory(pathName))
				{
					String[] strs = pathName.split("/");
					String temp = "";
					for (int i = 0; i < strs.length; i++)
					{
						temp = temp + strs[i] + "/";
						if (fClient.makeDirectory(temp))
						{
						}
					}
				}
			}catch(Exception e){
				logger.error(e);
			}
		}
	}

	/**
	 * 关闭FTP连接
	 *
	 */
	public void closeFTP() {
		if (null != fClient) {
			try {
				fClient.logout();
			} catch (IOException ex) {
				logger.error(ex);
			} finally {
				try {
					fClient.disconnect();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}

	/**
	 * 远程移动ftp上的文件
	 *
	 * @from 源目录
	 * @to 目的目录
	 * @hostName  主机IP
	 * @userName  用户名
	 * @passWord  密码
	 * @timeOut  超时时间
	 * @return int FTPUtils.OPERATE_SUCCEED 或者 FTPUtils.OPERATE_FAIL
	 */
	public boolean moveRemoteFile(String from, String to)throws IOException {
		boolean re = false;
		int ret = threeCon(hostName, userName, passWord, timeOut);
		if (OPERATE_FAIL == ret)
		{
			return false;
		}
		re = fClient.rename(from, to);
		return re;
	}



	private int threeCon(String hostName, String userName, String passWord, int timeOut) {
		if (null != fClient) {
			return OPERATE_SUCCEED;
		}
		for (int i = 0; i < 3; i++) {
			int inConn = connect();
			if (OPERATE_FAIL == inConn) {
				continue;
			}

			return OPERATE_SUCCEED;
		}

		return OPERATE_FAIL;
	}
}
