package examples.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<String>();
        lst.add("123");
        lst.add("ab");
        lst.add("50/50");
        Iterator<String> iter = lst.iterator();
        iter.next();
        iter.remove();
        iter.forEachRemaining(System.out::println);
    }
}
