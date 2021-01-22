package lesson36.Demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Demo {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("number.txt"));
        String str;
        List<String> list = new ArrayList<>();
        while ((str = br.readLine()) != null){
            list.add(str);
        }
        Collections.sort(list);
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("number.txt"));
        for (int i = 0; i < list.size(); i++){
            bw.write(list.get(i));
            bw.write(System.lineSeparator());
        }
        bw.flush();
        bw.close();
    }
}
