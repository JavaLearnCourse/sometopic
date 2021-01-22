package lesson36.Demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoTwo {


    static String regex1 = "(([a-z];)*[a-z])\\s+([a-z0-9]+\\.txt)";
    static String regex2 = "(((([a-z])|([0-9]));)*[a-z0-9])\\s+([a-z0-9]+\\.txt)\\s+([a-z0-9]+\\.txt)";


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Matcher matcher = matcher(str, regex1);
        if (matcher.matches()){
                task1(matcher);
        }
        matcher = matcher(str, regex2);
        if (matcher.matches()){
            task2(matcher);
        }


    }


    private static void task2(Matcher matcher) throws IOException {
        task2(matcher, false);
    }

    private static void task1(Matcher matcher) throws IOException {
        task1(matcher, false);
    }


    private static void task2(Matcher matcher, boolean sorted) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(matcher.group(6).trim()));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(matcher.group(7).trim()));
        String [] strArrays = matcher.group(1).split(";");
        if (sorted) {
            Arrays.sort(strArrays);
        }
        for(String s : strArrays){
            try{
                int number = Integer.parseInt(s);
                bw2.append(s);
                bw2.append(System.lineSeparator());
            }  catch (NumberFormatException ex){
                bw.append(s);
                bw.append(System.lineSeparator());
            }
        }
        bw2.flush();
        bw.flush();

    }

    public  static void task1(Matcher matcher, boolean sorted) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(matcher.group(3)));
        String [] strArrays = matcher.group(1).split(";");
        if (sorted) {
            Arrays.sort(strArrays);
        }
        for(String s : strArrays){
            bw.append(s);
            bw.append(System.lineSeparator());
        }
        bw.flush();
    }

    public static Matcher matcher(String str, String regex){
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex, Pattern.MULTILINE);
        matcher = pattern.matcher(str);
        return  matcher;
    }
}
