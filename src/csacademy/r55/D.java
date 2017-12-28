package csacademy.r55;

import util.FastScanner;
import commons.Pair;

import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        char[][] mat = new char[n+1][m+1];
        for(int i = 0; i < n; i++) {
            String s = in.nextString();
            mat[i] = s.toCharArray();
        }
        int[] palinCost = new int[m];
        int[] normalCost = new int[m];

        for(int i = 0; i <= (m-1)/2; i++) {
            //palinCost[i] = calcPalinCost(mat, n, m, i);
            //normalCost[i] = calcNormalCost(mat, n, m, i);
            Pair<Integer, Integer> temp = new Pair<>(2, 3);
        }
        Arrays.sort(palinCost, 0, (m-1)/2);
    }


}
