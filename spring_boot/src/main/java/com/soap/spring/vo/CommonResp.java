package com.soap.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ipaynow0929 on 2018/1/11.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResp<E> implements Serializable {
    protected Paginator paginator;
    protected List<E> result;
}
