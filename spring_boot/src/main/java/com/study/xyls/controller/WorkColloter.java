package com.study.xyls.controller;

import com.ipaynow.hr.req.GetWorkDataReq;
import com.ipaynow.hr.service.SynWorkDataService;
import com.ipaynow.hr.service.WorkDataService;
import com.ipaynow.ipaynow_user.mvc_support.params.resp.CommonResp;
import com.ipaynow.operation_sdk.mvc_support.params.resp.MvcResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by ipaynow0929 on 2018/1/10.
 */
@RestController
public class WorkColloter {

    @Resource
    private SynWorkDataService synWorkDataService;
    @Resource
    private WorkDataService workDataService;
    

    @ApiOperation(value = "获取考勤数据",notes = "部门信息传部门名称")
    @RequestMapping("getWorkData")
    public MvcResponse getWorkData(@Valid GetWorkDataReq getWorkDataReq, BindingResult bindingResult) {
        CommonResp commonResp = workDataService.getWorkDataList(getWorkDataReq);
        return MvcResponse.generrateSucessMvcResponse(commonResp);
    }

    @RequestMapping("synWorkData")
    public void synWorkData() {
        synWorkDataService.synWorkData();
    }


}
