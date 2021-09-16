package dev.threds;

import java.util.Scanner;

class ProcessorSample {
    public void producer() throws InterruptedException{
        synchronized (this) {
            System.out.println ("Producer thread running ---");
            wait ();
            System.out.println ("Resumed --");
        }
    }
    public void consumer() throws InterruptedException{
        Scanner scanner=new Scanner (System.in);
        Thread.sleep (2000);
        synchronized (this){
            System.out.println ("Waiting for return key.");
            scanner.nextLine ();
            System.out.println ("Return key pressed.");
            notify ();
        }
    }
}
public class ProcessorWait {
    public static void main(String args[]) throws InterruptedException {
        var processor=new ProcessorSample ();
        var t1=new Thread (()->{
            try {
                processor.producer ();
            } catch (InterruptedException exception) {
                exception.printStackTrace ();
            }
        });
        var t2 = new Thread (()->{
            try {
                processor.consumer ();
            } catch (InterruptedException exception) {
                exception.printStackTrace ();
            }
        });
        t1.start ();
        t2.start ();
        t1.join ();
        t2.join ();
    }
}