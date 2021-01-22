package lesson;



public class Producer  extends Thread {




    private int counter = 0;
    private Counter c;

    public Producer(Counter c){
        this.c =  c;
    }

    @Override
    public void run() {
        while (!c.isFinish()){
            c.inc();
        }

    }





    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Producer p1 =new Producer(c);
        Producer p2 = new Producer(c);
        p1.start();
        p2.start();
        p1.join();
        p2.join();
        c.result();

    }
}
