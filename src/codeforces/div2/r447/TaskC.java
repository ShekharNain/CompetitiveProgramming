package codeforces.div2.r447;

import util.FastScanner;
import util.MathUtil;

import java.io.PrintWriter;
import java.util.*;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int m = in.nextInt(), n = 1000001;
        int[] s = new int[m+1];
        boolean[] marked = new boolean[n+1];
        boolean[] present = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            marked[i] = false;
            present[i] = false;
        }
        for (int i = 0; i < m; i++) {
            s[i] = in.nextInt();
            marked[s[i]] = true;
            present[s[i]] = true;
        }
        Set<Integer> nums = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        boolean flag = true;
        for (int i = m-1; i >= 0; i--) {
            if(marked[s[i]]) {
                result.add(s[i]);
                List<Integer> temp = new ArrayList<>();
                for (Integer num: nums
                     ) {
                    int x = MathUtil.gcdInt(num,s[i]);
                    if(!present[x]) {
                        flag = false;
                        break;
                    }
                    marked[x] = false;
                    temp.add(x);
                }
                nums.addAll(temp);
                nums.add(s[i]);
            }
            if(!flag) break;
        }
        if(flag) {
            out.println(result.size());
            Collections.sort(result);
            for (Integer num: result
                 ) {
                out.print(num);
                out.print(" ");
            }
        } else {
            out.println(-1);
        }
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
