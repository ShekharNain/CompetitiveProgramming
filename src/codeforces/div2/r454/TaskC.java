package codeforces.div2.r454;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        Set<Integer> set = IntStream.rangeClosed(0,25).boxed().collect(Collectors.toSet());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String action = in.nextString(), word = in.nextString();
            if(set.size() == 1 && i != n-1) {
                if(action.equals("!") || action.equals("?"))
                    ans++;
                continue;
            }
            if(action.equals(".") || action.equals("?")) {
                for (int j = 0; j < word.length(); j++) {
                    set.remove(word.charAt(j)-'a');
                }
            } else {
                for (int j = 0; j < 26; j++) {
                    if(word.indexOf('a'+j) == -1)
                        set.remove(j);
                }
            }
        }
        out.println(ans);
    }
}
