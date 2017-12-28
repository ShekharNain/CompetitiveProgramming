package csacademy.r57;

import util.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int [] foxes = new int[k];
        int [] hidings = new int[k];
        boolean [] ignored = new boolean[n+1];
        boolean [] hide = new boolean[n+1];
        for (int i = 0; i < n + 1; i++) {
            ignored[i] = hide[i] = false;
        }
        for (int i = 0; i < k; i++) {
            foxes[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            hidings[i] = in.nextInt();
            hide[hidings[i]] = true;
        }
        int ans = 0, tmp = -1;
        int cnt = 0;
        while(tmp != ans) {
            tmp = ans;
            ans = fun(ignored, hide, foxes, k, n, ans);
            cnt++;
            if(cnt > 1000) break;
        }
        for (int i = 0; i < k; i++) {
            if(!ignored[foxes[i]]) {
                int pos = foxes[i];
                int left = pos == 1 ? n : pos - 1;
                int right = pos == n ? 1 : pos + 1;
                if (hide[left] || hide[right]) {
                    ans++;
                } else ans += 2;
            }
        }
        out.println(ans);
    }

    int fun(boolean[] ignored, boolean[] hide, int[] foxes, int k, int n, int ans) {
        for (int i = 0; i < k; i++) {
            if(!ignored[foxes[i]]) {
                int pos = foxes[i];
                int left = (pos == 1 ? n : pos - 1);
                int right = (pos == n ? 1 : pos + 1);
                if (hide[left] && !hide[right]) {
                    hide[left] = false;
                    ignored[foxes[i]] = true;
                    ans++;
                } else if (!hide[left] && hide[right]) {
                    hide[right] = false;
                    ignored[foxes[i]] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
