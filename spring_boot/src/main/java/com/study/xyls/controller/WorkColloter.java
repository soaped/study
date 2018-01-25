package com.study.xyls.controller;


import com.study.xyls.req.GetWorkDataReq;
import com.study.xyls.vo.MvcResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by ipaynow0929 on 2018/1/10.
 */
@RestController
public class WorkColloter {

//    @Resource
//    private SynWorkDataService synWorkDataService;
//    @Resource
//    private WorkDataService workDataService;
    

    @ApiOperation(value = "获取考勤数据",notes = "部门信息传部门名称")
    @RequestMapping("getWorkData")
    public MvcResponse getWorkData(@Valid @RequestBody GetWorkDataReq getWorkDataReq, BindingResult bindingResult) {
       // CommonResp commonResp = workDataService.getWorkDataList(getWorkDataReq);
        return MvcResponse.generrateSucessMvcResponse("");
    }

//    @RequestMapping("synWorkData")
//    public void synWorkData() {
//        synWorkDataService.synWorkData();
//    }


}
