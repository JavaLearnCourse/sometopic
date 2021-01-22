package dockspb;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static Deque<Ship> ship = new ArrayDeque<>();

    public static void main(String[] args) {

        Sea a = new Sea(ship);
        Dock d = new Dock();
        d.work(ship);
        a.startShipGenerator();


    }
}
