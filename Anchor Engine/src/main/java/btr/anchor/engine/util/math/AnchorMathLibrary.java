package btr.anchor.engine.util.math;

import btr.anchor.engine.util.annotations.Unsupported;
import btr.anchor.engine.util.exception.MathException;
import btr.anchor.engine.util.exception.UndefinedException;

public class AnchorMathLibrary {

    public static final double PI = 3.141592653589793;

    /**
     * @param d
     * @return d as fraction (like {numerator, denominator})
     */
    public static long[] getFraction(double d) {
        long den = 1;
        while ((d * den) % 1 != 0) {
            den++;
        }
        long num = (long) (d * den);
        long[] ret = {num, den};
        return ret;
    }

    /**
     * @param n the Exponent
     * @param a the Base
     * @return a to the n (a<sup>n</sup>)
     * @throws MathException
     */
    public static double pow(long n, double a) throws MathException {
        double at = a;
        if (n == 0 && a == 0) throw new UndefinedException();
        if (n == 0) return 1;
        for (long i = 1; i < abs(n); i++) {
            a *= at;
        }
        return n > 0 ? a : 1 / a;
    }

    /**
     * @param a
     * @return The absolut value of a (|a|)
     */
    public static double abs(double a) {
        return a < 0 ? -a : a;
    }

    /**
     * @param n
     * @param a
     * @return The nth root of a
     * @throws MathException
     */
    public static double nthRoot(long n, double a) throws MathException {
        double x = 1;
        double prev;
        if (a == 0) return 0;
        if (a == Double.POSITIVE_INFINITY || a == Double.NEGATIVE_INFINITY) throw new MathException();
        while (abs(pow(n, x) - a) != 0) {
            prev = x;
            x = 1 / (double) n * ((n - 1) * x + a / pow(n - 1, x));
            if (prev == x) break;
        }
        return x;
    }

    /**
     * @param n The Exponent
     * @param a The Base
     * @return a to the n (a<sup>n</sup>)
     * @throws MathException
     */
    public static double pow(double n, double a) throws MathException {
        //(a)^num/den=den-rt(a^num)
        long[] f = getFraction(n);
        return nthRoot(f[1], pow(f[0], a));
    }

    /**
     * @param n
     * @return n!
     */
    @Unsupported
    public static long factorial(long n) {
        long res = n;
        while (n > 2) {
            n--;
            res *= n;
        }
        return res;
    }

    /**
     * @param x
     * @return The sin of x estimated with the Taylor series as a polynom of the 19th degree with values clipped between -2 PI and 2 PI
     */
    public static double sin(double x) {
        //Taylor series sin(x)=--n from 0 to Infinity--(-1)^n*x^(2n+1)/(2n+1)!
        x = x % (2 * PI);
        double res = 0;
        if (x == PI) return 0;
        for (long n = 0; n < 10; n++) {
            try {
                res += pow(n, -1) * pow(2 * n + 1, x) / factorial(2 * n + 1);
            } catch (MathException e) {
                return res;
            }
        }
        return res;
    }

    public static double cos(double x) {
        return sin(PI / 2 - x);
    }

    public static double tan(double x) {
        return sin(x) / cos(x);
    }

    //asin(sin(a))=a
    //sin(a)=Gegenkathete/Hypotenuse
    //Im Einheitskreis:
    //sin(a)=Gegenkathete
    //sin(res)=a

    /**
     * @param x
     * @param precision
     * @return The asin of x with the given percision of radian fractures
     * @throws MathException
     */
    public static double asin(double x, long precision) throws MathException {
        x = abs(x);
        double res = 0;
        boolean d;
        for (long n = 2; n <= precision; n++) {
            d = false;
            //estimate until overshoot
            while (abs(sin(res) - x) > pow((long) -abs(n), 10) && res < 2 * PI) {
                res += PI / (double) n;
                d = true;
            }
            //if there's no overshoot return
            if (abs(sin(res) - x) == 0) return res;
            //undershoot to get better next time
            if (d) {
                res -= PI / (double) n;
            }
        }
        return res;
    }

    /**
     * @param x
     * @param precision
     * @return The acos of x with the given percision of radian fractures
     * @throws MathException
     */
    public static double acos(double x, long precision) throws MathException {
        x = abs(x);
        double res = 0;
        boolean d;
        for (long n = 2; n <= precision; n++) {
            d = false;
            //estimate until overshoot
            while (abs(cos(res) - x) > pow((long) -abs(n), 10) && res < 2 * PI) {
                res += PI / (double) n;
                d = true;
            }
            //if there is no overshoot return
            if (abs(cos(res) - x) == 0) return res;
            //undershoot to get a better result next time
            if (d) {
                res -= PI / (double) n;
            }
        }
        return res;
    }

    /**
     * @param x
     * @param precision
     * @return The atan of x with the given percision of radian fractures
     * @throws MathException
     */
    public static double atan(double x, long precision) throws MathException {
        x = abs(x);
        double res = 0;
        boolean d;
        for (long n = 2; n <= precision; n++) {
            d = false;
            //estimate until overshoot
            while (abs(tan(res) - x) > PI / (double) n && res < 2 * PI) {
                res += PI / (double) n;
                d = true;
            }
            //if there is no overshoot return
            if (tan(res) == x) return res;
            //undershoot to get a better result next time
            if (d) {
                res -= PI / (double) n;
            }
        }
        return res;
    }

}