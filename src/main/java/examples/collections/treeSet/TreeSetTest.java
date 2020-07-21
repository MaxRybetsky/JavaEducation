package examples.collections.treeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 5462));
        parts.add(new Item("Modem", 8907));
        System.out.println(parts);
        Set<Item> sortByDesc = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDesc.addAll(parts);
        System.out.println(sortByDesc);
    }
}
