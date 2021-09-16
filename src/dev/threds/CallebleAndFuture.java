package dev.threds;

import java.util.Random;
import java.util.concurrent.*;

public class CallebleAndFuture {
    public static void main(String args[]){
        ExecutorService executorService= Executors.newCachedThreadPool ();
        Future<Integer> future=executorService.submit (new Callable<Integer> (){
            @Override
            public Integer call () throws Exception {
                Random random=new Random ();
                int duration=random.nextInt (1000);
                if (duration>800){
                    throw new RuntimeException ("Duration more than 800");
                }
                System.out.println ("Starting----");
                Thread.sleep (duration);
                System.out.println ("Finished----");
                return duration;
            }
        });
        executorService.shutdown ();
        try {
            System.out.println ("Duration "+future.get ());
        } catch (InterruptedException exception) {
            exception.printStackTrace ();
        } catch (ExecutionException e) {
            e.printStackTrace ();
        }
    }
}
