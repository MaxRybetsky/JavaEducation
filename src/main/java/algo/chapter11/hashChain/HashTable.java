package algo.chapter11.hashChain;

public class HashTable {
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new SortedList[this.arraySize];
        for (int i = 0; i < this.arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + ". ");
            hashArray[i].displayList();
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link link) {
        int hashVal = hashFunc(link.getiData());
        hashArray[hashVal].insert(link);
    }

    public void delete(int key) {
        hashArray[hashFunc(key)].delete(key);
    }

    public Link find(int key) {
        return hashArray[hashFunc(key)].find(key);
    }
}
