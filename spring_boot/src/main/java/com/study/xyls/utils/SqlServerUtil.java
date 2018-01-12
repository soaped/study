package com.study.xyls.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ipaynow0929 on 2018/1/8.
 */
public class SqlServerUtil {

    public static Connection getSqlServerCon(String dbUrl,String userName,String userPwd) {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(dbUrl, userName, userPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
