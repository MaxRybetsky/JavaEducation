package examples.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List<Number> nums = Arrays.<Number>asList(1.3F, 2.4F);
        List<Integer> ints = Arrays.asList(1, 3);
        Collections.copy(nums, ints);
        System.out.println(Arrays.toString(nums.toArray()));
    }
}
