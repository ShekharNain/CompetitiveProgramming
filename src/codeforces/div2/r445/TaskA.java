package codeforces.div2.r445;

import util.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int[] arr = new int[7];
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        if((sum & 1) == 0) {
            sum >>= 1;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    for (int k = j + 1; k < 6; k++) {
                        if(arr[i] + arr[j] + arr[k] == sum) {
                            out.println("YES");
                            return;
                        }
                    }
                }
            }
        }
        out.println("NO");
    }
}
