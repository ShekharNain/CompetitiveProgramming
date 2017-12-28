package util;

public class MathUtil {
    // Euclid GCD algo
    public static int gcdInt(int a, int b) {
        if(b == 0) return a;
        return gcdInt(b, a%b);
    }

    public static long gcdLong(long a, long b) {
        if(b == 0) return a;
        return gcdLong(b, a%b);
    }


}
