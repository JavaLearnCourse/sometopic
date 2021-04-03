package lambda;


interface StringFunc{
    String func(String n);
}




public class Demo {


    static String stringOp(StringFunc sf, String s){
        return sf.func(s);
    }


    public static void main(String[] args) {
        String o = stringOp((str) ->  str.toUpperCase(), "cdfgrft");
        System.out.println(o);

        String y = stringOp(MyOp::strReverse, "FFDFA");


    }




}


class MyOp{

    static String strReverse(String str){
        String result = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--){
            result += str.charAt(i);
        }

        return result;
    }
}