package read;

import java.io.*;

public class Demo {


    public static void main(String[] args) throws IOException {
        File f = new File("fite.txt");
        System.out.println(f.getTotalSpace());
        BufferedInputStream is = new BufferedInputStream( new FileInputStream(f));

        System.out.println((char) is.read());
        System.out.println((char) is.read());


        System.out.println((char) is.read());
        is.mark(5);
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        is.reset();
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        is.reset();
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());



    }
}
