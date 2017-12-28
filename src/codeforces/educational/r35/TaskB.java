package codeforces.educational.r35;

import util.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            ans = Math.max(ans, calc(i,a,b,n));
        }
        out.println(ans);
    }

    private int calc(int i, int a, int b, int n) {
        int na = a / (i+1);
        int nb = b / (n-i-1);
        return Math.min(na,nb);
    }


}
