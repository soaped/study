package com.xyls.common.sorter.sort;

import com.ipaynow.npacc.common.sorter.SortUtil;

/**
 * @author treeroot
 * @since 2006-2-2
 * @version 1.0
 */
public class SelectionSort extends Swap implements SortUtil.Sort {

    /*
     * (non-Javadoc)
     *
     * @see org.rut.util.algorithm.SortUtil.Sort#sort(int[])
     第一个和后面所有的最小数交换，第二个和后面所有的最小数交换，以此类推
     */
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int lowIndex = i;
            for (int j = data.length - 1; j > i; j--) {
                if (data[j] < data[lowIndex]) {
                    lowIndex = j;
                }
            }
            swap(data,i,lowIndex);
        }
    }

}

