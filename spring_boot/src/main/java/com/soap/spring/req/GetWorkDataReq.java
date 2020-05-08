package com.soap.spring.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by ipaynow0929 on 2018/1/11.
 */
@Data
@ApiModel("部门参数")
public class GetWorkDataReq extends BaseReqPaginator {

    //@NotNull(message = "部门不能为空;")
    @ApiModelProperty(value = "部门ID",required = true,example = "7")
    private String dept;

    //@NotNull(message = "工号不能为空;")
    private String empNo;

    //@NotNull(message = "员工名称不能为空;")
    private String empName;

}
