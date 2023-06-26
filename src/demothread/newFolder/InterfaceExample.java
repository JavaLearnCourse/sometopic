package demothread;

import java.util.concurrent.atomic.AtomicInteger;

public class InterfaceExample {

    private static final int LIMIT = 100_000_000;

    private AtomicInteger counter = new AtomicInteger();

    public boolean stop() {
        return counter.incrementAndGet() > LIMIT;
    }

    public void example() throws InterruptedException {
        InterfaceThread t1 = new InterfaceThread(this);
        InterfaceThread t2 = new InterfaceThread(this);
        t1.start();
        t2.start();
        t1.join();
        System.out.println("Expected " + LIMIT);
        System.out.println("Result " + t1.getI());
    }

    public static void main(String[] args) {
        try {
            new InterfaceExample().example();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
