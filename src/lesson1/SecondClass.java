package lesson1;

import java.io.*;

public class SecondClass {


    public static void main(String[] args) {
        File f = new File("fite.txt");
        try(RandomAccessFile is = new RandomAccessFile(f, "rw")){
            int k = 0;
            is.seek(2);
            while ((k = is.read()) != -1){
                System.out.println((char) k);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
