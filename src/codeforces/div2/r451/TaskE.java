package codeforces.div2.r451;

import util.FastScanner;
import commons.PairIntInt;

import java.io.PrintWriter;
import java.util.*;

public class TaskE {
    private final static int LIM = (int) 1e9;
    TreeSet<Integer> squares = new TreeSet<>();

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        //List<Integer> squares = new ArrayList<>();
        squares.add(0);
        for (int i = 1; i <= LIM/i; i++) {
            squares.add(i*i);
        }
        int tmpsq = (int) Math.sqrt(LIM);
        tmpsq++;
        squares.add(tmpsq*tmpsq);
        int n = in.nextInt();
        PairIntInt[] arr = new PairIntInt[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            arr[i] = new PairIntInt(Math.min(x-squares.floor(x), squares.ceiling(x)-x), nonSqWork(x));
        }

        long ans = Arrays.stream(arr)
                .mapToLong(PairIntInt::getFirst)
                .sorted()
                .limit(n/2)
                .sum();
        if(ans == 0) {
            ans = Arrays.stream(arr)
                    .mapToLong(PairIntInt::getSecond)
                    .sorted()
                    .limit(n/2)
                    .sum();
        }
        out.println(ans);
    }

    private int nonSqWork(int num) {
        if(!isPerfectSquare(num)) return 0;
        if(!isPerfectSquare(Math.max(num-1,0)) || !isPerfectSquare(num+1)) return 1;
        if(!isPerfectSquare(Math.max(num-2,0)) || !isPerfectSquare(num+2)) return 2;
        if(!isPerfectSquare(Math.max(num-3,0)) || !isPerfectSquare(num+3)) return 3;
        return 100;
    }

    private boolean isPerfectSquare(int num) {
        return squares.contains(num);
    }
}
