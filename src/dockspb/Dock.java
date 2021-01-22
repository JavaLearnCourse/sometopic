package dockspb;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Dock {


    private Semaphore dock = new Semaphore(2);

    public  void work(Deque<Ship> sea){

            Thread t  = new Thread(() -> {
                synchronized (sea) {
                while (true) {
                        if (sea.isEmpty()){
                            System.out.println("HEU");
                            try {
                                sea.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {

                            sea.getFirst().unlod(dock);

                        }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
            });


            t.start();

    }


}
