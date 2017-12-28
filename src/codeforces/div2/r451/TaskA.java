package codeforces.div2.r451;



import util.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = n%10;
        if(x <= 5) {
            n -= x;
        } else {
            n += 10-x;
        }
        out.println(n);
    }
}
