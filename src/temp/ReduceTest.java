package temp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReduceTest {

    public static void main(String[] args) {
        //Task is to count the freq of each element in an array
        //1 1 1 2 2 3 3 4 4 4 4 -> (1,3) (2,2) (3,2) (4,4)
        List<Integer> arr = Arrays.asList(1,3,4,1,1,2,2,3,3,2,4,1,4,4,4);
        arr.stream().reduce(new HashMap<Integer, Integer>(), (acc, val) -> {
            //acc.compute(val, (k,v) -> v == null ? 1 : v + 1);
            acc.merge(val, 1, (x1, x2) -> x1+x2);
            return acc;
        }, (l,r) -> l)
        .forEach((k,v) -> System.out.println("key: " + k + " val: " + v));
    }
}
