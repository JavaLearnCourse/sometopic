package dockspb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Ship {

    private static  int count = 0;
    private int number;
    private List<Product> products = new ArrayList();

    public Ship(int space) {

        for (int i = 0; i < space; i++){
            products.add(new Product());
        }
        count = ++number;
    }

    public void unlod(Semaphore dock){
        try {
            dock.acquire(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = products.size() - 1; i >= 0; i-- ){
            System.out.println("Идет разгрузка судна " + number);
            products.remove(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        dock.release();
    }
}
