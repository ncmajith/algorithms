package com.company;

import java.util.Scanner;

public class EuclidsAlgorithm {

    public static void main(String[] args) {
	    Scanner scanner=new Scanner (System.in);
        System.out.println ("Enter number one");
        Integer a=scanner.nextInt ();
        System.out.println ("Enter number two");
        Integer b=scanner.nextInt ();
        Integer devicer=a<=b?a:b;
        Integer devident=a>=b?a:b;
        while (devicer!=0){
            Integer reminder=devident%devicer;
            devident=devicer;
            devicer=reminder;
        }
        System.out.println (devident);
        /**
         * using single line
         */
        System.out.println (gcd(a,b));

    }

    /**
     *
     * @param a
     * @param b
     * @return gcd using euclids in a single line
     */
    public static int gcd(int a,int b)
    {
        return b==0?a:gcd (b,a%b);
    }
}
