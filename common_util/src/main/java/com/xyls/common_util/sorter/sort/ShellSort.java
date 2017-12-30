package com.xyls.common.sorter.sort;

import com.ipaynow.npacc.common.sorter.SortUtil;

/**
 * @author treeroot
 * @since 2006-2-2
 * @version 1.0
 */
public class ShellSort extends Swap implements SortUtil.Sort{

    /* (non-Javadoc)
     * @see org.rut.util.algorithm.SortUtil.Sort#sort(int[])
     */
    public void sort(int[] data) {
        for(int i=data.length/2;i>2;i/=2){
            for(int j=0;j<i;j++){
                insertSort(data,j,i);
            }
        }
        insertSort(data,0,1);
    }

    /**
     * @param data
     */
    private void insertSort(int[] data, int start, int inc) {
        for(int i=start+inc;i<data.length;i+=inc){
            for(int j=i;(j>=inc)&&(data[j]<data[j-inc]);j-=inc){
                swap(data,j,j-inc);
            }
        }
    }

}

