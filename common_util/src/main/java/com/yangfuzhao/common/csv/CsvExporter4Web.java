package com.yangfuzhao.common.csv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * 导出csv 工具类
 * Created with IntelliJ IDEA.
 * User: benyamin
 * Date: 17-6-29
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class CsvExporter4Web {

    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_GBK = "GBK";

    /**
     * 第一步初始化 ，初始化响应头
     * @param request
     * @param response
     */
    public static void start(HttpServletRequest request, HttpServletResponse response, String exportName) throws Exception{
        //设置response
        response.setContentType("text/plain");
        response.setCharacterEncoding("GBK");
        response.setContentType("application/x-msdownload;charset=GBK");
        //增加了对火狐浏览器文件名 乱码的兼容
        String agent = (String) request.getHeader("USER-AGENT");
        if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
            response.setHeader("Content-Disposition", "attachment; filename*=gbk'zh_cn'" + URLEncoder.encode(exportName, CHARSET_GBK) + ".csv");
        } else {
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(exportName, CHARSET_UTF8) + ".csv");
        }
    }

    /**
     * 写入文件头
     * @param response
     * @param header
     * @throws Exception
     */
    public static void writeHeader( HttpServletResponse response, byte[] header) throws Exception{
        response.getOutputStream().write(header);
    }

    /**
     * 写入记录
     * @param response
     * @param response
     * @param row
     * @throws Exception
     */
    public static void writeRow( HttpServletResponse response, byte[] row) throws Exception{
        response.getOutputStream().write(row);
    }


    /**
     * 关闭流
     * @param response
     * @throws Exception
     */
    public static void finish( HttpServletResponse response) throws Exception{
       flush(response);
        response.getOutputStream().close();
    }

    /**
     * flush
     * @param response
     * @throws Exception
     */
    public static void flush( HttpServletResponse response) throws Exception{
        response.getOutputStream().flush();
    }

}
