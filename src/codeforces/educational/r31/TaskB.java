package codeforces.educational.r31;

import util.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), len = in.nextInt();
        int[] encoding = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            encoding[i] = in.nextInt();
            if(i != n-1) cnt += encoding[i] + 1;
        }
        cnt += encoding[n-1];
        if(cnt == len) out.println("YES");
        else out.println("NO");
    }
}
