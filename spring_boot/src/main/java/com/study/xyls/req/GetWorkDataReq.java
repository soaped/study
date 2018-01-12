package com.study.xyls.req;

import com.ipaynow.ipaynow_user.mvc_support.params.req.BaseReqPaginator;
import lombok.Data;

/**
 * Created by ipaynow0929 on 2018/1/11.
 */
@Data
public class GetWorkDataReq extends BaseReqPaginator {

    //@NotNull(message = "部门不能为空;")
    private String dept;

    //@NotNull(message = "工号不能为空;")
    private String empNo;

    //@NotNull(message = "员工名称不能为空;")
    private String empName;

}
