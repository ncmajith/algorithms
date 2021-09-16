package dev.threds;

import java.util.logging.Logger;

class Printer{
    public static final Logger logger= Logger.getLogger (MultiThreadingExample.class.getName ());
    synchronized void printDocument(int numberOfCopies,String docName){
        int index=0;
        while (index<=numberOfCopies) {
            logger.info ("Printing "+docName+" "+index);
            index++;
        }
    }
}
class MyThread extends Thread{
    Printer pRef=new Printer ();
    @Override
    public void run () {
        pRef.printDocument (10,"myPdg.pdf");
    }
}
class YourThread extends Thread{
    Printer pRef=new Printer ();
    @Override
    public void run () {
        pRef.printDocument (10,"yourPdg.pdf");
    }
}
public class MultiThreadingExample {
    public static final Logger logger= Logger.getLogger (MultiThreadingExample.class.getName ());
    public static void main(String args[]){
        logger.info ("== Starting of main thread ==");
//        var printer=new Printer ();
//        printer.printDocument (10,"Balarama");
        var myThread=new MyThread ();
        myThread.start ();
        var yourThred=new YourThread ();
        yourThred.start ();
        logger.info ("== Ending of main thread ==");
    }
}
