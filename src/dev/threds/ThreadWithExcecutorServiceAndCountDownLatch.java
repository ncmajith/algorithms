package dev.threds;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class sampleThreadOne implements Runnable{
    private CountDownLatch latch;
    public sampleThreadOne(CountDownLatch latch){
        this.latch=latch;
    }
    @Override
    public void run () {
        System.out.println ("Starting---");
        try {
            Thread.sleep (1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace ();
        }
        latch.countDown ();
        System.out.println ("Count "+latch.getCount ());
    }
}

public class ThreadWithExcecutorServiceAndCountDownLatch {
    public static void main(String args[]) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch (10);
        ExecutorService executorService= Executors.newFixedThreadPool (2); // create number of executer for thread.
        for(int i=0;i<10;i++)
        {
            executorService.execute (new sampleThreadOne (countDownLatch));
            /** Execute thread one by one
             *  if one executer become free then that executer start work in new task or thread */
        }
        countDownLatch.await ();
        System.out.println ("Completed");
    }
}
