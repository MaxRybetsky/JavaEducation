package algo.chapter2;

public class OrderedArray {
    private long[] a;
    private int nElems;

    public OrderedArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public int find(long searchKey) {
        int lowBound = 0;
        int upBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowBound + upBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowBound > upBound) {
                return nElems;
            }
            if (a[curIn] > searchKey) {
                upBound = curIn - 1;
            } else {
                lowBound = curIn + 1;
            }
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
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == value) {
                break;
            }
        }
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
