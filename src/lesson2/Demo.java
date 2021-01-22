package lesson2;

public class Demo {

    public static void main(String[] args) {
        int a[] = {4,6,8};
        hasPrimeNumber(a);
        binar(5);
        gcd(15,5);
    }

    public  static void hasPrimeNumber(int [] a){
        boolean isPrime = false;
       loop: for (int i = 0; i < a.length; i++){
            int k = 0;
            if ( a[i] < 2){
                k++;
            }
            for (int j = 2; j < a[i]; j++){
                if (a[i] % j == 0 ){
                    k++;
                    break;
                }
            }

            if (k == 0){
                isPrime = true;
                break loop;
            }
        }
        if(isPrime){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public  static  void binar (int k ) {
        String s = "";
        while (k > 0) {
            s = (k % 2) + s;
            k /= 2;
        }
        System.out.println(s);
    }
    public static  void gcd(int a, int b){
        int x, y;
        x = a;
        y = b;
        int t = 0;
        while (y > 0){
            t = y;
            y =  x % y;
           x = t;
        }
        System.out.println(x);

    }


}
