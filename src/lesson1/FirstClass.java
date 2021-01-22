package lesson1;

import java.io.*;


public class FirstClass {


    public static void main(String[] args) {
       File f = new File("fite.txt");
       try(InputStream is  = new FileInputStream(f)){
           byte []b = new byte[1024];
           int k = is.available() / 4;

           System.out.printf("Доступно для чтения %d байт  \nБудем читать циклом while первые %d байт\n"
                   , is.available(), k);

           int i = 0;
           while (is.read() != -1  && i++ < k);
           System.out.printf("Прочитано %d байт. Доступно %d байт\n", i, is.available());
           is.read(b, 4 , 12);
           for (byte b1 : b){
               System.out.println((char)b1);
           }

           System.out.println("Доступно для чтения   " + is.available());
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}
