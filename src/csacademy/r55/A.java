package csacademy.r55;

import util.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int Temp[] = new int[m];
        for (int i = 0; i < m; i++) {
            Temp[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++) {
            int l = in.nextInt(), r = in.nextInt();
            int cnt = 0;
            for(int j = 0; j < m ;j++) {
                if(l <= Temp[j] && r >= Temp[j])
                    cnt++;
            }
            out.println(cnt);
        }
    }
}
