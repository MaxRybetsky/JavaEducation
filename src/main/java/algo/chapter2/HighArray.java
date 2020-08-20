package algo.chapter2;

public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }
        return j != nElems;
    }

    public void insert(long value) {
        a[nElems] = value;
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

    public long getMax() {
        if(nElems == 0) return -1;
        long max = a[0];
        for (int i = 1; i < nElems; i++) {
            if(max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public long removeMax() {
        long max = getMax();
        delete(max);
        return max;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
}
