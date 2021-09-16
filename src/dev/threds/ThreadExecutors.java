package dev.threds;

import dev.threds.samplethreds.ThreadByExtendingThread;
import dev.threds.samplethreds.ThreadByImplementingRunnable;

import java.util.logging.Logger;

public class ThreadExecutors {
    public static final Logger logger = Logger.getLogger (ThreadExecutors.class.getName ());
    // Main thread
    public static void main(String args[]){
        // Worker thread
        ThreadByExtendingThread threadByExtendingThread=new ThreadByExtendingThread ();
        threadByExtendingThread.start ();
        // By Runnable
        Runnable myThread=new ThreadByImplementingRunnable();
        Thread task=new Thread (myThread);
        task.start();
        var flag=0;
        while (flag<=10) {
            logger.info ("## "+flag+"% ##");
            flag++;
        }
    }
}
