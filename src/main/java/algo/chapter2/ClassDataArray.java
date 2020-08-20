package algo.chapter2;

public class ClassDataArray {
    private final Person[] a;
    private int nElems;

    public ClassDataArray(int size) {
        a = new Person[size];
        nElems = 0;
    }

    public Person find(String searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchKey)) {
                break;
            }
        }
        return j == nElems ? null : a[j];
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchName)) {
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
            System.out.print(j + 1 + ". ");
            a[j].displayPerson();
        }
    }
}
