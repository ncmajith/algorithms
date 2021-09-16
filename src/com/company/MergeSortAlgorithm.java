package com.company;

import java.util.Arrays;
import java.util.logging.Logger;

public class MergeSortAlgorithm {
    public static final Logger logger= Logger.getLogger (MergeSortAlgorithm.class.getName ());
    private static void sort(int start,int end,int [] arr){
        if(start!=end){
            int middle=(start+end)/2;
            sort(start,middle,arr);
            sort(middle+1,end,arr);
            merge(start,end,arr);
        }
    }

    private static void merge(int start,int end,int [] arr){
        for(int i=start;i<end;i++) {
            if (arr[i] >= arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    public static void main(String args[]){
        long start=System.currentTimeMillis ();
        int[]list=new int[]{50,2,4,1,8,3,10,34};
        sort(0,list.length-1,list);
        Arrays.stream(list).forEach (System.out::print);
        long end=System.currentTimeMillis ();
        System.out.println ("\t"+(end-start));
    }

}
