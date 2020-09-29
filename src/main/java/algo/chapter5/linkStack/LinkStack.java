package algo.chapter5.linkStack;

import algo.chapter5.firstLastList.FirstLastList;

public class LinkStack {
    private FirstLastList list;

    public LinkStack() {
        list = new FirstLastList();
    }

    public void push(long j) {
        list.insertFirst(j);
    }

    public long pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void displayStack(){
        list.displayList();
    }
}
