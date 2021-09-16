package dev.threds.samplethreds;

import java.util.logging.Logger;

/**
 * author : Ajith
 */

class Counter{
    public Integer getCounterMax(){
        return 10;
    }
    public Integer getCounterStart(){
        return 0;
    }
}

public class ThreadByImplementingRunnable extends Counter implements Runnable{
    public static final Logger logger = Logger.getLogger (ThreadByImplementingRunnable.class.getName ());
    @Override
    public void run () {
        var flag=getCounterStart();
        while (flag<=getCounterMax()) {
            logger.info ("## "+flag+"% ##");
            flag++;
        }
    }
}
