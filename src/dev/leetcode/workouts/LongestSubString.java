package dev.leetcode.workouts;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubString {
    static Scanner scanner=new Scanner (System.in);
    public static void main(String args[]){
        System.out.println ("enter string");
        char[] userInput=scanner.nextLine ().toCharArray ();
        if(userInput.length<=1) {
            System.out.println (userInput.length);
        }else{
            String[] arr=new String[userInput.length];
            int arrayIndex=0,sizeOfSubString=0;
            for(int i=0;i<userInput.length;i++){
                arr[arrayIndex]=userInput[i]+"";
                int j=i+1;
                while(j<userInput.length){
                    if(!arr[arrayIndex].contains (userInput[j]+"")){
                        arr[arrayIndex]+=userInput[j];
                        if(j==userInput.length-1){
                            sizeOfSubString=incrementAndCalculateSize(arr,arrayIndex,sizeOfSubString);
                        }
                    }
                    else {
                        sizeOfSubString=incrementAndCalculateSize(arr,arrayIndex,sizeOfSubString);
                        break;
                    }
                    j++;
                }
            }
            System.out.println (sizeOfSubString);
        }
    }
    public static int incrementAndCalculateSize(String[] arr,int index,int sizeOfSubString){
        if(arr[index].length ()>sizeOfSubString) sizeOfSubString=arr[index].length ();
        index++;
        return sizeOfSubString;
    }
}
