package codeforces.div2.r451;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskD {
    private final int LIM = 1000001;
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[] arr = new int[LIM+1];
        Arrays.parallelSetAll(arr, i->0);
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            arr[x]++;
        }

        /*TreeMap<Integer, Integer> numMap = IntStream.rangeClosed(0, LIM)
                .filter(i -> arr[i] > 0)
                .boxed()
                .reduce(new TreeMap<Integer, Integer>(),
                        (map, v) -> {map.putIfAbsent(v, arr[v]); return map;}, (l,r) -> l);

        int sum = Arrays.stream(arr).limit(m).sum();*/
        int cnt = 0, ans = 0;
        for (int i = 1; i <= m; i++) {
            cnt += arr[i];
            if(cnt == k) {
                cnt = k-1;
                arr[i] = 0;
                ans++;
            }
        }
        for (int i = 2; i < LIM-m+1; i++) {
            cnt -= arr[i-1];
            cnt += arr[m+i-1];
            if(cnt == k) {
                cnt = k-1;
                arr[m+i-1] = 0;
                ans++;
            }
        }
        out.println(ans);
    }


}
