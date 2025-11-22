import java.math.BigInteger;

public class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero");
        }

        // Normalize sign
        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }

        // Reduce fraction
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public BigInteger getNumerator() { return numerator; }
    public BigInteger getDenominator() { return denominator; }

    // Arithmetic operations
    public Rational add(Rational other) {
        BigInteger num = numerator.multiply(other.denominator)
                .add(other.numerator.multiply(denominator));
        BigInteger den = denominator.multiply(other.denominator);
        return new Rational(num, den);
    }

    public Rational subtract(Rational other) {
        BigInteger num = numerator.multiply(other.denominator)
                .subtract(other.numerator.multiply(denominator));
        BigInteger den = denominator.multiply(other.denominator);
        return new Rational(num, den);
    }

    public Rational multiply(Rational other) {
        return new Rational(numerator.multiply(other.numerator),
                denominator.multiply(other.denominator));
    }

    public Rational divide(Rational other) {
        return new Rational(numerator.multiply(other.denominator),
                denominator.multiply(other.numerator));
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) return numerator.toString();
        return numerator + "/" + denominator;
    }
}

