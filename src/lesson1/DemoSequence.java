package lesson1;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class DemoSequence {

    public static void main(String[] args) {
        List<String> files = new ArrayList<>();
        files.add("fite.txt");
        files.add("number.txt");
        files.add("text.txt");
        MyOwnEnumerator enumerator = new  MyOwnEnumerator(files);
        int c;
        InputStream input = new SequenceInputStream(enumerator);
        try {
            while ((c = input.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static class MyOwnEnumerator implements      Enumeration<FileInputStream>  {


        private Iterator<String> filesName;

        private MyOwnEnumerator(List<String> filesName) {
            this.filesName = filesName.iterator();
        }

        @Override
        public boolean hasMoreElements() {
            return filesName.hasNext();
        }

        @Override
        public FileInputStream nextElement() {
            try {
                return new FileInputStream(filesName.next().toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}


