package threadfile;

import java.io.*;
import java.util.Scanner;

public abstract class Worker {

    protected File file;

    public Worker(File file) {
        this.file = file;
    }


    public abstract  void doTask();

    protected synchronized   String readCurrentFile() {
        String numberString = null;
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            numberString = sc.next();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sc != null) {
            sc.close();
        }

        return numberString;
    }

    protected synchronized void writeInFile(String content){
        try {
            Writer wr = new FileWriter(file);
            wr.write(content);
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public   synchronized void incrementer(){
        int number = Integer.parseInt(readCurrentFile());
        number++;
        writeInFile(String.valueOf(number));
        System.out.println(number);
    }
    public synchronized void decrementer(){
        int number = Integer.parseInt(readCurrentFile());
        number--;
        writeInFile(String.valueOf(number));
        System.out.println(number);
    }
}
