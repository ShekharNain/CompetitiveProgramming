package codeforces.div2.r454;

import util.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int f = in.nextInt(), m = in.nextInt(), c = in.nextInt(), x = in.nextInt();
        boolean flag = true;
        for (int i = c; i <= 2*c; i++) {
            if(i >= x && i <= 2*x) {
                c = i;
                flag = false;
                break;
            }
        }
        if(flag) {
            out.println(-1);
            return;
        }
        flag = true;
        for (int i = m; i <= 2*m; i++) {
            if(i > c && i > 2*x) {
                m = i;
                flag = false;
                break;
            }
        }
        if(flag) {
            out.println(-1);
            return;
        }
        flag = true;
        for (int i = f; i <= 2*f; i++) {
            if(i > m) {
                f = i;
                flag = false;
                break;
            }
        }
        if(flag) {
            out.println(-1);
            return;
        }
        out.println(f);
        out.println(m);
        out.println(c);
    }
}
