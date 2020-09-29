package algo.chapter5.linkQueue;

import algo.chapter5.firstLastList.FirstLastList;

public class LinkQueue {
    private FirstLastList list;

    public LinkQueue(){
        list = new FirstLastList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void insert (long j) {
        list.insertLast(j);
    }

    public long remove() {
        return list.deleteFirst();
    }

    public void displayQueue(){
        list.displayList();
    }
}
