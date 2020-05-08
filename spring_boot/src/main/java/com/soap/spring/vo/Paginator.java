package com.soap.spring.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * user: Z
 * Date: 15-4-27
 * Time: 上午11:38
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paginator {

    /*
     * 默认页码
     */
    public final static int DEFAULT_PAGE = 1;
    /*
     * 每页默认条数
     */
    public final static int DEFAULT_PAGE_SIZE = 20;

    /**
     * 页码
     */
    private int currentPage;
    /**
     * 每页大小
     */
    private int pageSize;
    /**
     * 总页数
     */
    private long pageNum;
    /**
     * 总记录数
     */
    private long totalCount;

    /**
     * 数据中心分页使用
     * 每页第一条记录索引 - orderIndex (pageFlag=-1)
     * 上一页使用
     */
    private String orderIndexPrevate;

    /**
     *
     * 每页最后一条索引 - orderIndex（pageFlag=1）
     * 下一页使用
     */
    private String orderIndexNext;

    private Integer prevTotalCount;//前面N个十分钟对应的总数
    private Integer currentTotalCount;//当前N个十分钟对应的总数
    private Integer tenNum;//查询10分钟次数
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date factTransDateBegin;//实际查询开始日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date factTransDateEnd;//实际查询结束日期


    private Integer pageType;// 1首页标识 -1尾页标识

    /**
     * 分页数据构造解函数
     * @param currentPage 当前页
     * @param pageSize 每页条数
     * @param pageNum 总页数
     * @param totalCount 总条数
     */
    public Paginator(int currentPage, int pageSize, int pageNum, long totalCount){
        this(currentPage, pageSize);
        this.pageNum = pageNum;
        this.totalCount = totalCount;
    }
    public Paginator(Integer currentPage){
        this(currentPage,DEFAULT_PAGE_SIZE);
    }
    public Paginator(Integer currentPage, Integer pageSize){
        if(currentPage == null || currentPage < 1){
            currentPage = DEFAULT_PAGE;
        }
        if(pageSize == null || pageSize < 1){
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }


    private void computePageNum(){
        Long nowTotalCount = this.totalCount;
        if(nowTotalCount != 0){
            this.pageNum = nowTotalCount/this.pageSize; //计算总页数
            if(nowTotalCount%this.pageSize!=0){ //总条数除不尽每页显示条数时，总页数加一
                this.pageNum++;
            }
        }
    }
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
        this.computePageNum();
    }

}
