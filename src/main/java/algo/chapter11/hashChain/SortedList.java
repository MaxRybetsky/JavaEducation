package algo.chapter11.hashChain;

public class SortedList {
    private Link first;

    public SortedList() {
        this.first = null;
    }

    public void insert(Link link) {
        int key = link.getiData();
        Link previous = null;
        Link current = first;
        while (current != null && key > current.getiData()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = link;
        } else {
            previous.next = link;
        }
        link.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;
        while (current != null && key != current.getiData()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public Link find(int key) {
        Link current = first;
        while(current!= null && current.getiData() <= key) {
            if(current.getiData() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
