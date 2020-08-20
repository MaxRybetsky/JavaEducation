package algo.chapter2;

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        arr.display();
        HighArray sorted = new HighArray(maxSize);
        long max = arr.removeMax();
        while(max != -1) {
            sorted.insert(max);
            max = arr.removeMax();
        }
        sorted.display();
    }
}
