package lesson;

public class Demo {


    public static void main(String[] args) {
        int m = max(4,5);
        System.out.println("Max " + m);
        int m1 = max(4,9);
        System.out.println("Maximal number " + m1);

        double m2 = Math.cos(30 );

       // String v2 = someMathod();

    }


    public static int max(int a, int b) {
        if (a  > b) {
            return a;
        } else {
            return b;
        }
    }



}
