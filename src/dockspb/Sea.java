package dockspb;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Sea class with ships
 */
public final class Sea  implements  Runnable{

    private Deque<Ship> ship;

    private int k = 0;

    public Sea(Deque<Ship> ship) {
        this.ship = ship;
    }

    public  void startShipGenerator(){
        Thread t = new Thread(this);
        t.start();
    }


    public void produceShip(){

           while (true) {
               synchronized (ship) {
                       ship.add(new Ship(7));
                       System.out.println("Новый пароход ожидает порта");
                       if (!ship.isEmpty())
                         ship.notifyAll();
                   try {
                       Thread.sleep(6000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
    }



    public Ship nextShip(){
        if (!ship.isEmpty())
            return ship.removeFirst();
        else
            return null;
    }


    @Override
    public void run() {
        produceShip();
    }
}
