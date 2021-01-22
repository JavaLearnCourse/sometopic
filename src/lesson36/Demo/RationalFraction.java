package lesson36.Demo;


import java.math.BigInteger;

public class RationalFraction {
    private int numerator;
    private int denominator;

    public RationalFraction() {
        //	numerator = denominator = 0;
        this(0, 1);
    }

    public static void main(String[] args) {
        RationalFraction a = new RationalFraction(35, 49);
        RationalFraction b = new RationalFraction(15, 20);

        a.sub2(b);
        a.print();


    }
    public RationalFraction(int n, int d) {
        this.numerator = n;
        this.denominator = d;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void reduce() {

        int reduce = gcd();
        //System.out.println("=====was===reduced=====");
        numerator /= reduce;
        denominator /= reduce;
    }

    private  int gcd() {
        BigInteger b1 = BigInteger.valueOf(numerator);
        BigInteger b2 = BigInteger.valueOf(denominator);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    public RationalFraction add(RationalFraction x) {

        if (getDenominator() == x.getDenominator()) {
            int newNumerator = getNumerator() + x.getNumerator();
            RationalFraction fraction = new RationalFraction(newNumerator, getDenominator());
            fraction.reduce();
            return fraction;
        }
        else {
            int commonDenominator = getDenominator() * x.getDenominator();
            int valueOfLeftNumerator = getNumerator() * x.getDenominator();
            int valueOfRightNumerator = x.getNumerator() * getDenominator();
            int sum = valueOfLeftNumerator + valueOfRightNumerator;
            RationalFraction fraction = new RationalFraction(sum, commonDenominator);
            fraction.reduce();
            return fraction;

        }

    }
    // 3 /  5 - 4 / 15  =  3 /  5  + (- 4 / 15)

    public void add2(RationalFraction x) {
        if (getDenominator() == x.getDenominator()) {
            int newNumerator = getNumerator() + x.getNumerator();
            this.numerator = newNumerator;
            this.reduce();
        }
        else {
            int commonDenominator = getDenominator() * x.getDenominator();
            int valueOfLeftNumerator = getNumerator() * x.getDenominator();
            int valueOfRightNumerator = x.getNumerator() * getDenominator();
            int sum = valueOfLeftNumerator + valueOfRightNumerator;
            this.numerator = sum;
            this.denominator = commonDenominator;
            this.reduce();

        }
    }
    public RationalFraction sub(RationalFraction x) {
        x.numerator = -x.numerator;
        return add(x);

    }

    public void sub2(RationalFraction x) {
        x.numerator = -x.numerator;
        add2(x);
    }



    public void print() {
        System.out.println("rational fraction: " + numerator + "/" + denominator);
    }

    @Override
    public String toString() {
        return "rational fraction: " + numerator + "/" + denominator;
    }

}