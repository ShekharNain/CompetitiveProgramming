package codeforces.div2.r429;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        String str = in.nextString();
        int[] arr = new int[26];
        Arrays.parallelSetAll(arr, i -> 0);
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'a']++;
            if(arr[str.charAt(i)-'a'] > k) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }
}
