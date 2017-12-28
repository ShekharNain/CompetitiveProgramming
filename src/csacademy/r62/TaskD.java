package csacademy.r62;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = IntStream.range(0, n)
                .map(i -> in.nextInt())
                .toArray();
        int start = 0, mx = arr[0], ans = 1, mxCnt = 0, last = -1;
        for (int i = 0; i < n; i++) {
            if(mx < arr[i]) {
                int cnt = calc(arr, start+1, i-1, last);
                last = mx;
                mx = arr[i];
                mxCnt = Math.max(mxCnt, cnt);
                start = i;
                ans++;
            }
        }
        int cnt = calc(arr, start+1, n-1, last);
        mxCnt = Math.max(mxCnt, cnt);
        out.println(ans + mxCnt-1);
    }

    private int calc(int[] arr, int l, int r, int last) {
        int res = 0, mx = last;
        for (int i = l; i <= r; i++) {
            if(mx < arr[i]) {
                mx = arr[i];
                res++;
            }
        }
        return res;
    }
}
