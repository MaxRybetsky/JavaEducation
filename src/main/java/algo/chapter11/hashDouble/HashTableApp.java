package algo.chapter11.hashDouble;

import algo.chapter11.hash.DataItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTableApp {
    public static void main(String[] args) throws IOException {
        DataItem item;
        int key;
        int size;
        int n;
        int keysPerCell;
        System.out.println("Enter size of hash table:");
        size = getInt();
        System.out.println("Enter initial number of items:");
        n = getInt();
        keysPerCell = 2;

        HashTable hashTable = new HashTable(size);
        for (int i = 0; i < n; i++) {
            key = (int) (Math.random() * keysPerCell * size);
            item = new DataItem(key);
            hashTable.insert(item);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("Enter first letter of" +
                    " show, insert, delete, find or exit: ");
            char ch = getChar();
            switch (ch) {
                case 's':
                    hashTable.displayTable();
                    break;
                case 'i':
                    System.out.println("Enter key value to insert: ");
                    key = getInt();
                    item = new DataItem(key);
                    hashTable.insert(item);
                    break;
                case 'd':
                    System.out.println("Enter key value to delete: ");
                    key = getInt();
                    hashTable.delete(key);
                    break;
                case 'f':
                    System.out.println("Enter key value to find: ");
                    key = getInt();
                    item = hashTable.find(key);
                    if(item != null) {
                        System.out.println("Found " + key);
                    } else {
                        System.out.println("Couldn't find " + key);
                    }
                    break;
                case 'e':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid entry!");
                    break;
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static char getChar() throws IOException {
        return getString().charAt(0);
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
