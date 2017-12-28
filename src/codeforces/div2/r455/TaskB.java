package codeforces.div2.r455;

import commons.PairIntInt;
import util.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                boolean found = false;
                for (int k = 0; k < pairs.size(); k++) {
                    if(pairs.get(k).equals(i)) {
                        found = true;
                        pairs.set(k,j);
                        break;
                    }
                }
                if(!found) pairs.add(j);
            }
        }
        out.println(pairs.size());
    }
}
