package codeforces.div2.r449;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class TaskC {
    String S = "What are you doing at the end of the world? Are you busy? Will you save us?";
    String A = "What are you doing while sending \"";
    String B = "\"? Are you busy? Will you send \"";
    String C = "\"?";
    long LIM = (long) 1e18;
    int slim = 100001;
    long[] f = new long[slim];
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        int d = A.length() + B.length() + C.length();
        Arrays.parallelSetAll(f, i -> d);
        f[0] = S.length();
        Arrays.parallelPrefix(f, (left, right) -> {
            long tmp = 2*left + right;
            return tmp > LIM ? LIM : tmp;
        });

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            long k = in.nextLong();
            //out.println("Here" + i);
            out.print(fun(n,k));
        }
    }
    private char fun(int n, long k) {
        if(n == 0) {
            return k > S.length() ? '.' : S.charAt((int) (k-1));
        }

        if(k <= A.length())
           return A.charAt((int) (k-1));
        if(k-A.length() <= f[n-1])
            return fun(n-1, k-A.length());
        if(k-A.length()-f[n-1] <= B.length())
            return B.charAt((int) (k-A.length()-f[n-1]-1));
        if(k-A.length()-f[n-1]-B.length() <= f[n-1])
            return fun(n-1, k-A.length()-f[n-1]-B.length());
        if(k-A.length()-2*f[n-1]-B.length() <= C.length())
            return C.charAt((int) (k-A.length()-2*f[n-1]-B.length()-1));
        return '.';
    }
}
