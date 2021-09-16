package dev.leetcode.workouts;

import java.util.*;
import java.util.stream.Collectors;

public class MedianOfTwoArray {
    public static void main(String args[]){
        int[] one={1,3};
        int[] two={2};
        findMedianSortedArraysRevised(one,two);
    }
    public static double findMedianSortedArrays(int[] one, int[] two) {
        int [] mergedArray=new int[one.length+two.length];
        int indexOfOne=0,indexOfTwo=0,indexOfMergedArray=0;
        while(indexOfOne<one.length && indexOfTwo<two.length){
            if(one[indexOfOne]<two[indexOfTwo]){
                mergedArray[indexOfMergedArray++]=one[indexOfOne++];
            }
            else{
                mergedArray[indexOfMergedArray++]=two[indexOfTwo++];
            }
        }
        while (indexOfOne<one.length) mergedArray[indexOfMergedArray++]=one[indexOfOne++];
        while (indexOfTwo<two.length) mergedArray[indexOfMergedArray++]=two[indexOfTwo++];
        double median=0.0;
        int middle=mergedArray.length/2;
        if(mergedArray.length%2>0){
            median=mergedArray[middle];
        }else
        {
            median=(double) (mergedArray[middle-1]+mergedArray[middle])/2;
        }
        return median;
    }
    public static double findMedianSortedArraysRevised(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return findMedianSortedArrays(nums2, nums1);	// Make sure A2 is the shorter one.
        int low = 0;
        int high = nums2.length * 2;
        System.out.println(Arrays.toString(nums2));
        while (low <= high) {
            int mid2 = (low + high) / 2;   // Try Cut 2
            int mid1 = nums1.length + nums2.length - mid2;  // Calculate Cut 1 accordingly
            System.out.println(mid2);
            System.out.println(mid1);
            System.out.println("******");
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];	// Get L1, R1, L2, R2 respectively
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
            double R1 = (mid1 == nums1.length * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
            double R2 = (mid2 == nums2.length * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];
            if (L1 > R2) low = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
            else if (L2 > R1) high = mid2 - 1;	// A2's lower half too big; need to move C2 left.
            else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	// Otherwise, that's the right cut.
        }
        return -1;
    }
}
