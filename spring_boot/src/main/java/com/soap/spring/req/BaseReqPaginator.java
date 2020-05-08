package com.soap.spring.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * user: Mars
 * Date: 16-8-3
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseReqPaginator extends BaseReq {

    //当前页
    private Integer currentPage = 1;
    //每页多少条
    private Integer pageSize = 20;

}
