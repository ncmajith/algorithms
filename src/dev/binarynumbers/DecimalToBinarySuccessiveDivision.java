package dev.binarynumbers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class DecimalToBinarySuccessiveDivision {
    public static final Logger logger= Logger.getLogger (DecimalToBinarySuccessiveDivision.class.getName ());
    public static void main( String[] args ){
        long start=System.currentTimeMillis ();
        var sin=new Scanner (System.in);
        var decimalNumber=sin.nextInt ();
        if(decimalNumber==0) logger.info ("0");
        else getBinaryNumber(decimalNumber);
        long end=System.currentTimeMillis ();
        logger.info (""+(end-start)+" ms");
    }
    public static void getBinaryNumber(int desimal){
        var listBinary=new ArrayList<Integer> ();
        while(desimal!=0) {
            listBinary.add (desimal%2);
            desimal=desimal/2;
        }
        for(int i=listBinary.size ()-1;i>=0;i--)
            System.out.print (listBinary.get (i)+"");
        System.out.print("\n");
    }
}
