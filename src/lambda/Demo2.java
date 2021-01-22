package lambda;

interface MyFunc<T> {

    int func(T vals[], T v);
}

class MyArrayOp {
    
    


    public static <T> int countMatching(T[] ts, T t) {
        return 0;
    }
}

public class Demo2 {

    static <T>  int myOp(MyFunc<T> f, T[] vals, T v ){
        return  f.func(vals, v);
    }
    public static void main(String[] args) {
        String te = "FGDVSVFAVDASDDASDDD";

   //   myOp(MyArrayOp::<String>countMatching, te, "D");
    }

}
