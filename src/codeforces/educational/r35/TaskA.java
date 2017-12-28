package codeforces.educational.r35;

import commons.PairIntInt;
import util.FastScanner;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] ints = IntStream.range(0, n).map(i -> in.nextInt()).toArray();
        int mn = Arrays.stream(ints).min().getAsInt();
        int[] ids = IntStream.range(0,n).filter(i->ints[i] == mn).toArray();
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < ids.length; i++) {
            ans = Math.min(ans,ids[i]-ids[i-1]);
        }
        out.println(ans);
    }
}
