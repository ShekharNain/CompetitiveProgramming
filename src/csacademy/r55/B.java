package csacademy.r55;

import util.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), r = in.nextInt(), k = in.nextInt();
        int b = n - r;
        int min = k > r ? k - r : r - k;
        min = Math.min(min, r);
        int max = k > b ? b + (r - (k-b)) : k + r;
        out.println(min);
        out.println(max);
    }
}
