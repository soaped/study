package com.xyls.common.sorter.sort;

import com.ipaynow.npacc.common.sorter.SortUtil;

/**
 * @author treeroot
 * @since 2006-2-2
 * @version 1.0
 */
public class QuickSort extends Swap implements SortUtil.Sort{

    /* (non-Javadoc)
     * @see org.rut.util.algorithm.SortUtil.Sort#sort(int[])
     */
    public void sort(int[] data) {
        quickSort(data,0,data.length-1);
    }
    private void quickSort(int[] data,int i,int j){
        int pivotIndex=(i+j)/2;
        //swap
        swap(data,pivotIndex,j);

        int k=partition(data,i-1,j,data[j]);
        swap(data,k,j);
        if((k-i)>1) quickSort(data,i,k-1);
        if((j-k)>1) quickSort(data,k+1,j);

    }
    /**
     * @param data
     * @return
     */
    private int partition(int[] data, int l, int r,int pivot) {
        do{
           while(data[++l]<pivot);
           while((r!=0)&&data[--r]>pivot);
           swap(data,l,r);
        }
        while(l<r);
        swap(data,l,r);
        return l;
    }

}

