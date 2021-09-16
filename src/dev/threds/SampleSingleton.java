package dev.threds;

public class SampleSingleton {
    private static SampleSingleton sampleSingleton=new SampleSingleton ();
    private SampleSingleton(){

    }
    public static SampleSingleton Instance(){
        return sampleSingleton;
    }
}
