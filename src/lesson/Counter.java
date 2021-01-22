package lesson;

public class Counter {


    private  static int i = 0;


    private volatile int counter = 0;

    public final  static  int FINAL = 1_000_000;

    private static Object o = new Object();

    public  synchronized void inc(){
            i++;
    }


    public synchronized   boolean isFinish(){
        return counter++ >= FINAL;
    }

    public int getI() {
        return i;
    }


    public void result(){
        System.out.printf("Expected %d,  result %d, delta %d ", FINAL, getI(), getI() - FINAL);
    }
}
