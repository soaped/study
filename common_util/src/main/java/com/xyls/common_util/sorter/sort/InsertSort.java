package com.xyls.common.sorter.sort;

import com.ipaynow.npacc.common.sorter.SortUtil;

/**
 * @author treeroot
 * @since 2006-2-2
 * @version 1.0
 */
public class InsertSort extends Swap implements SortUtil.Sort{

    /* (non-Javadoc)
     * @see org.rut.util.algorithm.SortUtil.Sort#sort(int[])
     插入排序:从前往后，比当前元素和前面所有元素比较，如果顺序不对就换
     */
    public void sort(int[] data) {
        for(int i=1;i<data.length;i++){
            for(int j=i;(j>0)&&(data[j]<data[j-1]);j--){
                swap(data,j,j-1);
            }
        }
    }

}

