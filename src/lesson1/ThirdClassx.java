package lesson1;

import java.io.*;

public class ThirdClassx {

    public static void main(String[] args) {
        File f = new File("fite.txt");
        try (InputStream is = new FileInputStream(f)) {
            int c;
            while ((c = is.read()) != -1){
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
