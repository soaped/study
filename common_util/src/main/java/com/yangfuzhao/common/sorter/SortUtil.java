package com.yangfuzhao.common.sorter;

import com.ipaynow.npacc.common.sorter.sort.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class SortUtil {
	
	/**
	 * 字符串排序
	 * @param a，待排序的字符串
	 */
	public static void Sort(List<String> a){
		int y = a.size();
		for(int x = 0;x < a.size() - 1;x++){
			for(int i = 0;i<y - 1; i++){
				String str1 = a.get(i);
				String str2 = a.get(i+1);
				if(str1.compareTo(str2)>0){
					a.set(i, str2);
					a.set(i+1, str1);
				}
			}
			y = y-1;
		}
	}
	
	
	
	public static interface Sort {
		 public void sort(int[] data);
	 }
	public final static int INSERT = 1;
	public final static int BUBBLE = 2;
	public final static int SELECTION = 3;
	public final static int SHELL = 4;
	public final static int QUICK = 5;
	public final static int IMPROVED_QUICK = 6;
	public final static int MERGE = 7;
	public final static int IMPROVED_MERGE = 8;
	public final static int HEAP = 9;

	private static Sort[] impl=new Sort[]{
                           new InsertSort(),
                           new BubbleSort(),
                           new SelectionSort(),
                           new ShellSort(),
                           new QuickSort(),
                           new ImprovedQuickSort(),
                           new MergeSort(),
                           new ImprovedMergeSort(),
                           new HeapSort()
	};

	

 
	/**
	 * 将int[] 数组排序(升序)
	 * @data 待排序的int数组
	 * @algorithm 采用的排序算法,可以选择9种<br>
	 * 
	 * SortUtil.INSERT<br>
	 * SortUtil.BUBBLE<br>
	 * SortUtil.SELECTION<br>
	 * SortUtil.SHELL<br>
	 * SortUtil.QUICK<br>
	 * SortUtil.IMPROVED_QUICK<br>
	 * SortUtil.MERGE<br>
	 * SortUtil.IMPROVED_MERGE<br>
	 * SortUtil.HEAP<br>
	 */
	public static void sort(int[] data, int algorithm) {
		impl[algorithm-1].sort(data);
	}
	
	
	
	
	
	
	
	
	public static <T extends OrderAble> List<T> sort(List<T> orderAbles,boolean desc) {
	    
	    ArrayList<Integer> tmpdata = new ArrayList<Integer>();
        Hashtable<Integer,T> ht = new Hashtable<Integer,T>();
        for(T orderAble:orderAbles){
            int orderIndex = orderAble.getOrderIndex();
            if(orderIndex == OrderAble.ORDER_FILTER_INDEX) continue;
            while(ht.containsKey(orderIndex)){
                orderIndex++;
            }
            ht.put(orderIndex, orderAble);
            tmpdata.add(orderIndex);
        }
        int []date = new int[tmpdata.size()];
        int index = 0;
        for(int d:tmpdata){
            date[index] = d;
            index ++;
        }
        if(date.length > 0){
            SortUtil.sort(date, SortUtil.IMPROVED_QUICK);
        }
        List<T> result = new ArrayList<T>();
        if(desc){
            for(int i = 1;i <= date.length;i++){
                result.add(ht.get(date[date.length - i]));
            }
        }else{
            for(int i = date.length;i >= 1;i--){
                result.add(ht.get(date[date.length - i]));
            }
        }
        return result;
    }
	
	
	
	
	
	public static interface OrderAble {
	    public static final int ORDER_FILTER_INDEX = -1;
        public int getOrderIndex();
    }
}


