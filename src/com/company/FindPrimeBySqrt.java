package com.company;

import java.util.Scanner;

public class FindPrimeBySqrt {
    public static void main(String args[]){
        Scanner scanner=new Scanner (System.in);
        System.out.println ("Enter number one");
        int sqrt=((Double)sqrt (scanner.nextInt ())).intValue ();
        for(int firstNumber=1;firstNumber<=sqrt;sqrt++){

        }
    }
    public static double sqrt(int number){
        double t;
        double squareroot = number / 2;
        do
        {
            t = squareroot;
            squareroot = (t + (number / t)) / 2;
        }
        while ((t - squareroot) != 0);
        return squareroot;
    }
}
