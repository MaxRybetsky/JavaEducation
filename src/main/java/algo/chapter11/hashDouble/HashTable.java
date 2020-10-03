package algo.chapter11.hashDouble;

import algo.chapter11.hash.DataItem;

public class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[this.arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (DataItem dataItem : hashArray) {
            System.out.print((dataItem != null ? dataItem.getiData()
                    : "**") + " ");
        }
        System.out.println();
    }

    public int hashFunc1(int key) {
        return key % arraySize;
    }

    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(DataItem item) {
        int hashVal = hashFunc1(item.getiData());
        int stepSize = hashFunc2(item.getiData());
        System.out.println(item.getiData() + ":");
        while (hashArray[hashVal] != null &&
                hashArray[hashVal].getiData() != nonItem.getiData()) {
            System.out.print(hashArray[hashVal].getiData() + " ");
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        System.out.println();
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if(hashArray[hashVal].getiData() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if(hashArray[hashVal].getiData() == key) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
