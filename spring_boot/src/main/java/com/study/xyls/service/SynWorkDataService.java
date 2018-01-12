package com.ipaynow.hr.service;

import com.ipaynow.hr.dao.mybatis.domain.WorkData;
import com.ipaynow.hr.dao.mybatis.mapper.WorkDataMapper;
import com.ipaynow.hr.utils.SqlServerUtil;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ipaynow0929 on 2018/1/10.
 */
@Service
public class SynWorkDataService {

    @Value("${spring.datasource.sqlserver.url}")
    private String dbUrl;

    @Value("${spring.datasource.sqlserver.username}")
    private String userName;

    @Value("${spring.datasource.sqlserver.password}")
    private String userPwd;

    @Resource
    private WorkDataMapper workDataMapper;

    @Transactional(rollbackFor = Exception.class)
    public Integer synWorkData(){
        Connection con = SqlServerUtil.getSqlServerCon(dbUrl,userName,userPwd);
        ResultSet clockSet = null;
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT\n" +
                    "\tg.f_GroupName,\n" +
                    "\tc.f_ConsumerNO,\n" +
                    "\tc.f_ConsumerName,\n" +
                    "\ts.f_ShiftDate,\n" +
                    "\ts.f_OnDuty1,\n" +
                    "\ts.f_OnDuty1AttDesc,\n" +
                    "\ts.f_OffDuty1,\n" +
                    "\ts.f_OffDuty1AttDesc,\n" +
                    "\ts.f_LateMinutes,\n" +
                    "\ts.f_LeaveEarlyMinutes,\n" +
                    "\ts.f_OvertimeHours,\n" +
                    "\ts.f_AbsenceDays\n" +
                    "FROM\n" +
                    "\tt_d_shift_AttReport s,\n" +
                    "\tt_b_Consumer c,\n" +
                    "\tt_b_Group g \n" +
                    "WHERE\n" +
                    "\ts.f_ConsumerID = c.f_ConsumerID \n" +
                    "\tAND c.f_GroupID = g.f_GroupID";
            clockSet = statement.executeQuery(sql);
            while (clockSet.next()){
                WorkData workData = new WorkData();
                workData.setDept(clockSet.getString(1));
                workData.setEmpNo(clockSet.getString(2));
                workData.setEmpName(clockSet.getString(3));
                workData.setWorkDate(clockSet.getDate(4));
                workData.setOnDuty(clockSet.getDate(5));
                workData.setOnDutyDesc(clockSet.getString(6));
                workData.setOffDuty(clockSet.getDate(7));
                workData.setOffDutyDesc(clockSet.getString(8));
                workData.setLateMin(clockSet.getInt(9));
                workData.setLeaveEarlyMin(clockSet.getInt(10));
                workData.setOverTimeHours(clockSet.getInt(11));
                workData.setAbsenceDays(clockSet.getInt(12));
                try {
                    workDataMapper.insertSelective(workData);
                } catch (DuplicateKeyException dk){
                     continue;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

        return null;
    }
}
