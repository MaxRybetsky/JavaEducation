package exam.flat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED), false)
                .flatMap(e -> StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(e, Spliterator.ORDERED), false))
                .collect(Collectors.toList());
    }
}