package algo.chapter11.hash;

import javax.xml.crypto.Data;

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

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {
        int key = item.getiData();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null &&
                hashArray[hashVal].getiData() != nonItem.getiData()) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].getiData() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].getiData() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}
