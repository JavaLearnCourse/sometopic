package lesson1;

import java.io.*;

public class PushBack {

    public static void main(String[] args) {
        String s = "if (a == 4)  a = 0;\n";
        byte[] buf = new byte[s.length()];

        ByteArrayInputStream cr = new ByteArrayInputStream(buf);
        try (PushbackInputStream r = new PushbackInputStream(cr)){
            int c;
            while((c = r.read()) != -1){
                switch(c){
                    case '=':
                        if ((c = r.read()) == '='){
                            System.out.print(".eq");
                        } else {
                            System.out.print("<-");
                            r.unread(c);
                        }
                        break;
                        default:
                            System.out.println((char)c);
                }
            }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
