package codeforces.div2.r451;

import util.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        int x = -1, y = -1;
        for (int i = 0; i <= n; i++) {
            int tmp = n - a*i;
            if(tmp < 0) break;
            y = tmp / b;
            if(y*b == tmp) {
                x = i;
                y = tmp / b;
                break;
            }
        }
        if(x != -1) {
            out.println("YES");
            out.println(x + " " + y);
        } else {
            out.println("NO");
        }
    }
}
