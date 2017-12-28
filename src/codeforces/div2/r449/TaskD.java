package codeforces.div2.r449;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int[] arr = new int[]{10,100,20,200,30,300,40,400};

        boolean res = Arrays.stream(arr)
                .anyMatch(i -> i == 10);
    }

}
