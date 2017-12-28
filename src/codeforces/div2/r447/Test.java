package codeforces.div2.r447;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class Test {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.nextString();
        int noOfPalins = IntStream.range(0, s.length())
                .parallel()
                .map(id -> palins(s, id, 0, s.length()-1))
                .sum();
        out.println(noOfPalins);
        //System.out.println("Output is: " + noOfPalins);
    }

    private int palins(String s, int id, int lo, int hi) {
        int l = id, r = id+1, cnt = 0;
        while(l >= lo && r <= hi && s.charAt(l) == s.charAt(r)) {
            cnt++;
            l--;
            r++;
        }
        l = r = id;
        while(l >= lo && r <= hi && s.charAt(l) == s.charAt(r)) {
            cnt++;
            l--;
            r++;
        }
        return cnt;
    }
}

