package algo.chapter6.binarySearch;

public class BinarySearchApp {
    public static void main(String[] args) {
        OrdArray a = new OrdArray(100);
        a.insert(72);
        a.insert(90);
        a.insert(45);
        a.insert(126);
        a.insert(54);
        a.insert(99);
        a.insert(144);
        a.insert(27);
        a.insert(135);
        a.insert(81);
        a.insert(18);
        a.insert(108);
        a.insert(9);
        a.insert(117);
        a.insert(63);
        a.insert(36);
        a.display();
        int searchKey = 27;
        if(a.find(searchKey) != -1) {
            System.out.println("Found: " + searchKey);
        } else {
            System.out.println("Can't find: " + searchKey);
        }
    }
}
