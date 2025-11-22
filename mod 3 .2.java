import java.util.Scanner;
import java.math.BigInteger;

public class TestRational {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first rational number (numerator/denominator): ");
        String[] first = input.nextLine().split("/");
        Rational r1 = new Rational(new BigInteger(first[0]), new BigInteger(first[1]));

        System.out.print("Enter the second rational number (numerator/denominator): ");
        String[] second = input.nextLine().split("/");
        Rational r2 = new Rational(new BigInteger(second[0]), new BigInteger(second[1]));

        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    }
}
