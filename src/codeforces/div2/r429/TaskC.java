package codeforces.div2.r429;

import commons.PairIntInt;
import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int m = in.nextInt();
        Integer[] arrA = IntStream.range(0,m).map(i -> in.nextInt()).boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
        int[] arrB = IntStream.range(0,m).map(i -> in.nextInt()).toArray();
        PairIntInt[] parrB = IntStream.range(0,m).boxed().parallel()
                .map(i -> new PairIntInt(i,arrB[i]))
                .sorted(Comparator.comparing(PairIntInt::getSecond).thenComparing(Comparator.comparing(PairIntInt::getFirst).reversed()))
                .toArray(PairIntInt[]::new);
        int[] ans = new int[m];
        IntStream.range(0,m).forEach(id->ans[parrB[id].getFirst()] = arrA[id]);
        IntStream.range(0,m).forEach(id -> {
            out.print(ans[id] + " ");
        });
    }
}
