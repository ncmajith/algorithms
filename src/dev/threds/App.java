package dev.threds;

import java.util.Scanner;

class Processor extends Thread{
    private volatile boolean running=true;
    @Override
    public void run() {
        while (running){
            System.out.println ("hello");
            try {
                Thread.sleep (100);
            } catch (InterruptedException exception) {
                exception.printStackTrace ();
            }
        }
    }
    public void shutDown(){
        running=false;
    }
}
public class App {
    public static void main(String []args)
    {
//        var processor=new ProcessorWait ();
//        processor.start ();
//        System.out.println ("Press return to stop");
//        Scanner sanner=new Scanner (System.in);
//        sanner.nextLine ();
//        processor.shutDown ();
        var singleton=SampleSingleton.Instance ();
        var singletontwo=SampleSingleton.Instance ();
        var singletonthree=SampleSingleton.Instance ();
        System.out.println (singleton+ "<-->" + singletontwo + "<-->" + singletonthree);
    }
}
