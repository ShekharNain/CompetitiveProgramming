package codeforces.div2.r451;

import util.FastScanner;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        Map<String, List<String>> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextString();
            int cnt = in.nextInt();
            List<String> nums = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                String x = in.nextString();
                nums.add(x);
            }
            phoneBook.merge(s, nums, (list1, list2) ->
                    Stream.of(list1,list2)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList())
            );
        }
        phoneBook.keySet().forEach(key -> {
            phoneBook.compute(key, this::filterNumbers);
        });
        out.println(phoneBook.size());
        phoneBook.forEach((k, v) -> {
            out.print(k + " " + v.size());
            v.forEach(x -> out.print(" " + x));
            out.println();
        });
    }

    private List<String> filterNumbers(String s, List<String> list) {
        //List<String> result = list.stream().distinct().collect(Collectors.toList());
        return list.stream()
                .filter(num1 -> !(list.stream().anyMatch(num2 -> !num2.equals(num1) && num2.endsWith(num1)))
                        )
                .distinct()
                .collect(Collectors.toList());
    }
}
