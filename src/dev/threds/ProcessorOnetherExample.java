package dev.threds;

import java.util.LinkedList;
import java.util.Random;

class Process{
    private LinkedList<Integer> list=new LinkedList<> ();
    private  final int LIMIT=10;
    private Object lock=new Object ();
    public void produce() throws InterruptedException{
        int value=0;
        while(true){
            synchronized (lock){
                while(list.size ()==LIMIT) {
                    lock.wait ();
                }
                list.add (value++);
                lock.notify ();
            }
        }
    }
    public void consume() throws InterruptedException{
        Random random=new Random ();
        while(true){
            synchronized (lock){
                while(list.size ()==0) {
                    lock.wait ();
                }
                System.out.println ("List size is : "+list.size ());
                int value=list.removeFirst ();
                System.out.println ("the value is : "+value);
                lock.notify ();
            }
            Thread.sleep (random.nextInt (1000));
        }
    }
}

public class ProcessorOnetherExample {
    public static void main(String args[])throws InterruptedException{
        var processor=new Process ();
        var t1=new Thread (()->{
            try {
                processor.produce ();
            } catch (InterruptedException exception) {
                exception.printStackTrace ();
            }
        });
        var t2 = new Thread (()->{
            try {
                processor.consume ();
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
