package demothread;

import java.util.concurrent.atomic.AtomicInteger;

public class Example {


    public final static int LIMIT = 100_000_000;
    private AtomicInteger counter = new AtomicInteger();

    public boolean stop() {
        return counter.incrementAndGet() > LIMIT;
    }
}
