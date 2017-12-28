package codeforces.div2.r455;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s1 = in.nextString(), s2 = in.nextString();
        List<String> resuts = new ArrayList<>();
        for (int i = 1; i <= s1.length(); i++) {
            String s = s1.substring(0,i);
            for (int j = 1; j <= s2.length(); j++) {
                resuts.add(s+s2.substring(0,j));
            }
        }
        Collections.sort(resuts);
        //resuts.forEach(s -> out.println(s));
        out.println(resuts.get(0));
    }
}
