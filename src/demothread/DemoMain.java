package demothread;

public class DemoMain {

    public static void main(String[] args) {
        Example example = new Example();
        DemoThread t = new DemoThread(example);
        DemoThread t1 = new DemoThread(example);

        try {
            t.start();
            t1.start();
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Expected " + Example.LIMIT);
        System.out.println("Result " + t.getI());

    }
}
