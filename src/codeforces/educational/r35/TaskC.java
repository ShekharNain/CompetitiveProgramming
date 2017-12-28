package codeforces.educational.r35;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int[] arr = new int[3];
        arr[0] = in.nextInt();
        arr[1] = in.nextInt();
        arr[2] = in.nextInt();
        Arrays.sort(arr);
        if(arr[0] == 1 || (arr[0] == 2 && arr[1] == 2) || (arr[0] == 3 && arr[2] == 3)
                || (arr[0] == 2 && arr[1] == 4 && arr[2] == 4))
            out.println("YES");
        else out.println("NO");
    }
}
