package codeforces.educational.r35;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        int[][] mat = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            mat[i][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {

            }
        }
    }
}
