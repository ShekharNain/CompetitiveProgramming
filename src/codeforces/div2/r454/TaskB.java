package codeforces.div2.r454;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        List<StringBuilder> mat = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            StringBuilder str = new StringBuilder(in.nextString());
            str = str.append(in.nextString()).append(in.nextString());
            mat.add(str);
        }
        //mat.add(new StringBuilder("\n"));
        for (int i = 0; i < 3; i++) {
            StringBuilder str = new StringBuilder(in.nextString());
            str = str.append(in.nextString()).append(in.nextString());
            mat.add(str);
        }
        //mat.add(new StringBuilder("\n"));
        for (int i = 0; i < 3; i++) {
            StringBuilder str = new StringBuilder(in.nextString());
            str = str.append(in.nextString()).append(in.nextString());
            mat.add(str);
        }
        int x = in.nextInt(), y = in.nextInt();
        int tx = (x-1) % 3, ty = (y-1)%3;
        int sx = (tx*3), sy = ty*3;

        boolean flag = false;
        for(int i = sx; i < sx+3; i++) {
            for(int j = sy; j < sy+3; j++) {
                if(mat.get(i).charAt(j) == '.') {
                    flag = true;
                    break;
                }
            }
        }

        if(flag) {
            for(int i = sx; i < sx+3; i++) {
                for(int j = sy; j < sy+3; j++) {
                    if(mat.get(i).charAt(j) == '.') {
                        mat.get(i).setCharAt(j, '!');
                    }
                }
            }
        } else {
            for(int i = 0;i < 9; i++) {
                mat.set(i, new StringBuilder(mat.get(i).toString().replace('.', '!')));
            }
        }
        for (int i = 0; i < mat.size(); i++) {
            if(i%3 == 0 && i != 0)
                out.println();
            for(int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) out.print(' ');
                out.print(mat.get(i).charAt(j));
            }
            out.println();
        }
    }
}
