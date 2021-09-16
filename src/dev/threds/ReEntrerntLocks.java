package dev.threds;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner{
    int count=0;
    private Lock lock=new ReentrantLock ();
    private Condition condition=lock.newCondition ();
    public void increment(){
        for(int i=0;i<10000;i++){
            count++;
        }
    }
    public void producer() throws  InterruptedException{
        lock.lock ();
        System.out.println ("Waiting ---");
        condition.await ();
        System.out.println ("Woken up ---");
        try{
            increment ();
        }finally {
            lock.unlock ();
        }
    }
    public void consumer() throws  InterruptedException{
        Thread.sleep (1000);
        lock.lock ();
        System.out.println ("Press the return key ---");
        new Scanner (System.in).nextLine ();
        System.out.println ("Got the return key");
        condition.signal ();
        try{
            increment ();
        }finally {
            lock.unlock ();
        }
    }
    public void finished(){
        System.out.println ("Execution finished :"+count);
    }
}

public class ReEntrerntLocks {
    public static void main(String args[]) throws InterruptedException{
        Runner runner=new Runner ();
        Thread t1=new Thread (new Runnable () {
            @Override
            public void run () {
                try {
                    runner.producer ();
                } catch (InterruptedException exception) {
                    exception.printStackTrace ();
                }
            }
        });
        Thread t2=new Thread (new Runnable () {
            @Override
            public void run () {
                try {
                    runner.consumer ();
                } catch (InterruptedException exception) {
                    exception.printStackTrace ();
                }
            }
        });
        t1.start ();
        t2.start ();
        t1.join ();
        t2.join ();
        runner.finished ();
    }
}
