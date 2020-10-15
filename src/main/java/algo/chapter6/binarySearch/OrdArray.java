package algo.chapter6.binarySearch;

public class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public int find(long searchKey) {
        return recFind(searchKey, 0, nElems - 1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int currIn = (lowerBound + upperBound) / 2;
        if (a[currIn] == searchKey) {
            return currIn;
        }
        if (lowerBound > upperBound) {
            return -1;
        }
        if (a[currIn] < searchKey) {
            return recFind(searchKey, currIn + 1, upperBound);
        } else {
            return recFind(searchKey, lowerBound, currIn - 1);
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value) {
                break;
            }
        }
        for (int k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j != nElems) {
            for (int k = j; k < nElems - 1; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
        return false;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    public int size() {
        return nElems;
    }
}
