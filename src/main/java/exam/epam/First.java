package exam.epam;

import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        List l = list;
        l.add("S");
        for (Object o : l) {
            System.out.print(o + " ");
        }
    }
}
