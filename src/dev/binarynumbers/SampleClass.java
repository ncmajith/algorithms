package dev.binarynumbers;

public class SampleClass {
    public static void main(String... args){
        System.out.println (extracted ()+"");
    }

    private static int extracted () {
        try{
            int c=5/0;
        }catch (ArithmeticException ex){
            return 0;
        }finally {
            return 2;
        }
    }
}
