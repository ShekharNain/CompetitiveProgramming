package codeforces.div2.r455;

import util.FastScanner;
import util.MathUtil;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {
    private final int MOD = (int) (1e9+7);
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextString();
        }
        int[] dp = new int[n];
        Arrays.parallelSetAll(dp, i->0);
        dp[0] = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i].equals("f")) {
                cnt++;
                continue;
            }
            calc(dp,n,cnt);
            cnt = 0;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[i];
            sum %= MOD;
        }
        out.println(sum);
    }

    private void calc(int[] dp, int n, int cnt) {
        for (int i = n-1; i >= 0; i--) {
            if(i!=n-1) dp[i] += dp[i+1];
            dp[i] %= MOD;
        }
        //int[] tmp = new int[n];
        int prev = dp[0];
        for (int i = 0, y = 0; i < MathUtil.gcdInt(n,cnt); i++) {
            //tmp[(i+cnt)%n] = dp[i];
            y = i;
            prev = dp[i];
            do {
                int nextId = (y + cnt) % n;
                int tmp = dp[nextId];
                dp[nextId] = prev;
                prev = tmp;
                y = nextId;
            } while (y != i);

        }
        //Arrays.parallelSetAll(dp,i->tmp[i]);
    }
}
