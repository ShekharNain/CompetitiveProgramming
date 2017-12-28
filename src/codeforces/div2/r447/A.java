package codeforces.div2.r447;

import util.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.nextString();
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'Q') {
                for (int j = i+1; j < n; j++) {
                    if(s.charAt(j) == 'A') {
                        for (int k = j+1; k < n; k++) {
                            if(s.charAt(k) == 'Q')
                                cnt++;
                        }
                    }
                }
            }
        }
        out.println(cnt);
    }
}
