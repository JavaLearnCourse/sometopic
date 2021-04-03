package lesson1;

import java.io.*;


public class FirstClass {


    public static void main(String[] args) {
       File f = new File("fite.txt");
       try(InputStream is  = new FileInputStream(f)){

           int k = is.available() / 4;

           System.out.printf("Доступно для чтения %d байт  \nБудем читать циклом while первые %d байт\n"
                   , is.available(), k);

           for (int i = 0; i < k; i++) {
               System.out.println((char)is.read());
               /*
                72 = 01010000 = H
                101 = 1100101 = e
                */
           }
           System.out.println("Доступно для чтения   " + is.available());

           byte [] b = new byte[k];
           if (is.read(b) != k) {
               System.out.println("Не доступно " + k + " байтов");
           }
           System.out.println("--------");
           for (byte b1 : b ) {
               System.out.println((char)b1);
           }
           System.out.println(new String(b, 0, b.length));
           is.skip(k / 2);
           if (is.read(b, k / 2, k / 2) != k){
               System.out.println("Не доступно " + k + " байтов");
           }

           System.out.println(new String(b,  0, b.length));
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}
