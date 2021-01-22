package threadfile;

import java.io.File;

public class Threads {


    public static void main(String[] args) {
        File f = new File("number.txt");
        Incrementer in = new Incrementer(f);
        Decrementer de = new Decrementer(f);

        FileFabric fabric = new FileFabric(in, de);
        fabric.startThread();
    }
}
