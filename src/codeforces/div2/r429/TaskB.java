package codeforces.div2.r429;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = IntStream.range(0,n).map(i -> in.nextInt()).toArray();
        long sum = Arrays.stream(arr).mapToLong(i -> i).sum();
        int oddCnt = (int) Arrays.stream(arr).filter(i -> i%2 != 0).count();
        int evenCnt = (int) Arrays.stream(arr).filter(i -> i%2 == 0).count();
        if(sum % 2 != 0) {
            out.println("First");
        } else {
            if(oddCnt == 0) {
                out.println("Second");
            } else {
                out.println("First");
            }
        }
    }
}
