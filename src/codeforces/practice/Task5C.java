package codeforces.practice;

import util.FastScanner;
import commons.PairIntInt;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Task5C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.nextString();
        List<PairIntInt> pairLists = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty()) {
                    pairLists.add(new PairIntInt(stack.peek(), i));
                    stack.pop();
                }
            }
        }

        /*pairLists.stream()
                .sorted(Comparator.comparing(PairIntInt::getFirst))
                .filter()*/
        pairLists.sort(Comparator.comparing(PairIntInt::getFirst));
        PairIntInt init = new PairIntInt(-2,-2);
        int mx = 0, cnt = 1;
        for (int i = 0; i < pairLists.size(); i++) {
            PairIntInt current = pairLists.get(i);
            if(init.getSecond() == current.getFirst()-1) {
                init.setSecond(current.getSecond());
                int diff = init.getSecond() - init.getFirst() + 1;
                if(mx < diff) {
                    mx = diff;
                    cnt = 1;
                } else if (mx == diff) {
                    cnt++;
                }
            } else if (init.getSecond() < current.getFirst()) {
                init = current;
                int diff = init.getSecond() - init.getFirst() + 1;
                if(mx < diff) {
                    mx = diff;
                    cnt = 1;
                } else if (mx == diff) {
                    cnt++;
                }
            }

        }

        System.out.print(mx + " ");
        System.out.print(cnt);
    }

    /*private Predicate<PairIntInt> lastElementStatePredicate() {
        PairIntInt init = new PairIntInt(-2,-2);
        return current -> {
            boolean flag = init.getSecond() > current.getFirst();
            if(!flag)
                init = current;
            return !flag;
        };
    }*/
}
