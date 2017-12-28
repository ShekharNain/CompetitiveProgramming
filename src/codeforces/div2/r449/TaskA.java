package codeforces.div2.r449;

import util.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        StringBuilder s = new StringBuilder(in.nextString());
        for (int i = 0; i < m; i++) {
            int l = in.nextInt(), r = in.nextInt();
            char c1 = in.nextString().charAt(0), c2 = in.nextString().charAt(0);
            l--; r--;
            for (int j = l; j <= r; j++) {
                if(s.charAt(j) == c1) {
                    s.setCharAt(j,c2);
                }
            }
        }
        out.println(s);
    }
}
