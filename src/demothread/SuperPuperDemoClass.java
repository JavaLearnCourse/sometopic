package demothread;

import java.util.concurrent.atomic.AtomicInteger;

public class SuperPuperDemoClass {

    private int number = 0;

    public static  final  int ITERATIONS = 1_000_000;


    public void inc(){
        number++;
    }

    public boolean stop() {
        return  number > ITERATIONS;
    }

    public void print(){
        System.out.println(number);
    }
}
