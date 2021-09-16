package dev.threds.samplethreds;

import java.util.logging.Logger;

/**
 * author : Ajith
 */
public class ThreadByExtendingThread extends Thread{
    public static final Logger logger = Logger.getLogger (ThreadByImplementingRunnable.class.getName ());
    @Override
    public void run () {
        var flag=0;
        while (flag<=10) {
            logger.info ("## "+flag+"% ##");
            flag++;
        }
    }
}
