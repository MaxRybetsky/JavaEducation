package algo.chapter3.objectSort;

public class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public void display() {
        for (Person person : a) {
            if (person != null) {
                person.displayPerson();
            }
        }
        System.out.println();
    }

    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            Person person = a[out];
            in = out;
            while (in > 0
                    && a[in - 1].getLastName().compareTo(person.getLastName()) >= 0) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = person;
        }
    }
}
