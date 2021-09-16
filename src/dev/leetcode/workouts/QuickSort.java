package dev.leetcode.workouts;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int [] unSortedArr){
        int length=unSortedArr.length-1;
        int pivotElement=unSortedArr[length];
        int valueAtMid=unSortedArr[length/2];
        int mid=length/2;
        unSortedArr[mid]=pivotElement;
        unSortedArr[length]=valueAtMid;
        for(int index=0;index<=length;index++){
            if(unSortedArr[index]<pivotElement && index>mid ){
                int elementBeforeMid=unSortedArr[mid-1];
                unSortedArr[mid-1]=unSortedArr[index];
                unSortedArr[index]=elementBeforeMid;
            }else if(unSortedArr[index]>pivotElement && index<mid ){
                int elementAfterMid=unSortedArr[mid+1];
                unSortedArr[mid+1]=unSortedArr[index];
                unSortedArr[index]=elementAfterMid;
            }
        }
        Arrays.asList (unSortedArr).forEach (System.out::println);
    }
    public static void main(String []args){
        int[] arr={10,8,5,4,12,43};
        sort(arr);
    }
}
