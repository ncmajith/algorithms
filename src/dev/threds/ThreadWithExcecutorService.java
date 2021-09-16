package dev.threds;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class sampleThread implements Runnable{
    private int id;
    public sampleThread(int id){
        this.id=id;
    }
    @Override
    public void run () {
        System.out.println ("Starting---"+id);
        try {
            Thread.sleep (5000);
        } catch (InterruptedException exception) {
            exception.printStackTrace ();
        }
        System.out.println ("End---"+id);
    }
}

public class ThreadWithExcecutorService {
    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool (5); // create number of executer for thread.
        for(int i=0;i<10;i++)
        {
            executorService.execute (new sampleThread (i));
            /** Execute thread one by one
             *  if one executer become free then that executer start work in new task or thread */
        }
        executorService.shutdown (); // Will not shut down immediately , wait for executer to finish execution and will not assign new task
        executorService.awaitTermination (1, TimeUnit.HOURS); // like join executer will wait for shutdown process to finish in the defined period
    }
}
