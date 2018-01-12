package com.xyls.common.sorter.sort;


import com.xyls.common.sorter.SortUtil;

/**
 * @author treeroot
 * @since 2006-2-2
 * @version 1.0
 */
public class BubbleSort extends Swap implements SortUtil.Sort{


	/* (non-Javadoc)
     * @see org.rut.util.algorithm.SortUtil.Sort#sort(int[])
     从前往后循环的把最小数通过循环比较拿到最前
     */
    public void sort(int[] data) {
        for(int i=0;i<data.length;i++){
            for(int j=data.length-1;j>i;j--){
                if(data[j]<data[j-1]){
                    swap(data,j,j-1);
                }
            }
        }
    }

}

