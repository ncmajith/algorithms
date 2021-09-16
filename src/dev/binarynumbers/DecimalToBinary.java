package dev.binarynumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String args[]){
        long start=System.currentTimeMillis ();
        Scanner sin=new Scanner (System.in);
        int decimalNumber=sin.nextInt ();
        if(decimalNumber==0)
            System.out.println ("0");
        else
            getBinaryNumber(decimalNumber);
        long end=System.currentTimeMillis ();
        System.out.println ("\n"+(end-start)+" ms");
    }

    public static void getBinaryNumber(double desimal){
        double sum=0,exponent=0.0;
        List<Double> expArr=new ArrayList<> ();
        while(sum<desimal) {
            exponent = getExponent (desimal - sum);
            expArr.add (exponent);
            sum = sum + Math.pow (2, exponent);
        }
        double max=expArr.get (0);
        var binary=new ArrayList<Integer> ();
        int index=0;
        while(index<=max){
            binary.add (0);
            index++;
        }
        expArr.forEach (exp->{
            binary.set(exp.intValue (),1);
        });
        for(int i=binary.size ()-1;i>=0;i--)
            System.out.print(binary.get (i));
        System.out.print("\n");
    }

    private static int getExponent ( double desimal ) {
        int exponent=0;
        double times=0;
        while (times<= desimal)
        {
            exponent++;
            times=Math.pow (2,exponent);
        }
        return exponent-1;
    }

}
