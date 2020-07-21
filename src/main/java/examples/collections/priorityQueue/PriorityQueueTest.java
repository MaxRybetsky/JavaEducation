package examples.collections.priorityQueue;

import java.time.LocalDate;
import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));
        for (LocalDate ld : pq) {
            System.out.println(ld);
        }
        System.out.println("Removing");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
