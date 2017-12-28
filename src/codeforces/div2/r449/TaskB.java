package codeforces.div2.r449;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int k = in.nextInt(), p = in.nextInt();
        //int lim = 100000;
        /*
        long sum = IntStream.range(0,1000000000).parallel()
                .filter(value -> {
                   return String.valueOf(value).equals(new StringBuilder(String.valueOf(value)).reverse().toString());
                })
                .limit(lim)
                .sum();

        out.println(sum);*/
        long palin = 11;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans = (ans + palin) % p;
            palin = nextPalin(palin);
        }
        out.println(ans);
    }

    private long nextPalin(long palin) {
        //System.out.println(palin);
        String s = String.valueOf(palin);
        Integer x = Integer.parseInt(s.substring(0, s.length()/2));
        x = x + 1;
        s = String.valueOf(x);
        String str = s + new StringBuilder(s).reverse();
        return Long.valueOf(str);
    }
}
