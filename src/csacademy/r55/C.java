package csacademy.r55;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        long k = in.nextLong();
        int arr[] = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            max = Math.max(max, arr[i]);
        }
        out.println(BinarySearchForAnswer(1, max, k, arr));
    }

    private int BinarySearchForAnswer(int lo, int hi, long k, int arr[]) {
        while(lo < hi) {
            int mid = lo + ((hi-lo)>>1) + 1;
            if(isValid(mid, k, arr)) lo = mid;
            else hi = mid-1;
        }
        if(isValid(lo, k, arr)) return lo;
        return 0;
    }

    private boolean isValid(int height, long k, int arr[]) {
        long cnt = Arrays.stream(arr)
                .parallel()
                .mapToLong(x -> (long)x/height)
                .sum();

        if(cnt < k) {
            return false;
        }
        return true;
    }


}
