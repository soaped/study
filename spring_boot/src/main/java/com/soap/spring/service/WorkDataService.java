package com.soap.spring.service;

import org.springframework.stereotype.Service;

/**
 * Created by ipaynow0929 on 2018/1/11.
 */
@Service
public class WorkDataService {

//    @Resource
//    private WorkDataMapper workDataMapper;
//
//    public CommonResp getWorkDataList(GetWorkDataReq getWorkDataReq) {
//        WorkDataExample workDataExample = new WorkDataExample();
//        WorkDataExample.Criteria criteria = workDataExample.createCriteria();
//
//        if (StringUtils.isNotEmpty(getWorkDataReq.getDept())) {
//            criteria.andDeptEqualTo(getWorkDataReq.getDept());
//        }
//        if (StringUtils.isNotEmpty(getWorkDataReq.getEmpName())) {
//            criteria.andEmpNameEqualTo(getWorkDataReq.getEmpName());
//        }
//        if (StringUtils.isNotEmpty(getWorkDataReq.getEmpNo())) {
//            criteria.andEmpNoEqualTo(getWorkDataReq.getEmpNo());
//        }
//        CommonResp commonResp = new CommonResp();
//        int count = workDataMapper.countByExample(workDataExample);
//        if (count <= 0) {
//            return commonResp;
//        }
//        Paginator paginator = new Paginator(getWorkDataReq.getCurrentPage());
//        paginator.setTotalCount(count);
//        commonResp.setPaginator(paginator);
//        Page page = new Page(getWorkDataReq.getCurrentPage());
//        page.setLength(getWorkDataReq.getPageSize());
//        workDataExample.setPage(page);
//        List work = workDataMapper.selectByExample(workDataExample);
//        commonResp.setResult(work);
//        return commonResp;
//    }
}
