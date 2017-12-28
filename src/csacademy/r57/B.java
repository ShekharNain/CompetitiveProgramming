package csacademy.r57;

import util.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        long k = in.nextLong();
        String tmp = in.nextString();
        if(tmp.indexOf('1') == -1)
            out.println(k * n);
        else {
            String s = tmp;
            if(k > 1) s += tmp;
            int id = 0;
            int ans = 0;
            while (id < s.length()) {
                int id0 = s.indexOf('0', id);
                int id1;
                if(id0 == -1) break;
                id1 = s.indexOf('1', id0);
                if(id1 != -1)
                    ans = Math.max(ans, id1 - id0);
                else {
                    ans = Math.max(ans, s.length() - id0);
                    break;
                }
                id = id1;
            }
            out.println(ans);
        }
    }
}
