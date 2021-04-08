package demothread;

public class DemoThread extends Thread {

    private Example example;
    private  int i;

    public DemoThread(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        while (!example.stop()){
            increment();
        }
    }

    private synchronized void increment() {
        i++;
    }   
    
    public int getI(){
        return i;
    }
}
