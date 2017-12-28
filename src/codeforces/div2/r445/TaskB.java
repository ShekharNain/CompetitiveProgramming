package codeforces.div2.r445;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = IntStream.range(0, n)
                .map(i -> in.nextInt()).toArray();
        int cnt = (int) Arrays.stream(arr).distinct().count();
        Set<Integer> intSets = new TreeSet<>();
        for(int i = n-1; i >= 0; i--) {
            if(!intSets.contains(arr[i])) {
                if(intSets.size() == cnt-1) {
                    out.println(arr[i]);
                    return;
                }
                intSets.add(arr[i]);
            }

        }
    }
}
