package lesson1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoFOS {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("fit2.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s = "Helllo dsk,flgvds dasvfsgb";
        byte[] b = s.getBytes();
        for(int i = 0; i < b.length; i++){
            try {
                fos.write(b[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
