package csacademy.r57;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.nextString();
        int[] freq = new int[27];
        for (int i = 0; i < 26; i++) {
            freq[i] = in.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += freq[s.charAt(i)-'a'];
        }
        out.println(ans);
    }
}
