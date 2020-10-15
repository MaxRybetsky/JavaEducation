package algo.chapter6.merge;

public class MergeSortApp {
    public static void main(String[] args) {
        DArray a = new DArray(100);
        a.insert(64);
        a.insert(21);
        a.insert(33);
        a.insert(70);
        a.insert(12);
        a.insert(85);
        a.insert(44);
        a.insert(3);
        a.insert(99);
        a.insert(0);
        a.insert(108);
        a.insert(36);
        a.display();
        a.mergeSort();
        a.display();
    }
}
