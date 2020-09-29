package algo.chapter5.doublyLinked;

public class DoublyLinkedList {
    private Link first;
    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        Link link = new Link(dd);
        if (isEmpty()) {
            last = link;
        } else {
            first.previous = link;
        }
        link.next = first;
        first = link;
    }

    public void insertLast(long dd) {
        Link link = new Link(dd);
        if (isEmpty()) {
            first = link;
        } else {
            link.previous = last;
            last.next = link;
        }
        last = link;
    }

    public Link deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Link temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Link temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long dd) {
        if (isEmpty()) {
            insertFirst(dd);
        }
        Link current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Link link = new Link(dd);
        if (current == last) {
            link.next = null;
            last = link;
        } else {
            link.next = current.next;
            current.next.previous = link;
        }
        link.previous = current;
        current.next = link;
        return true;
    }

    public Link deleteKey(long key) {
        if (isEmpty()) {
            return null;
        }
        Link current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        if (current == first) {
            first = current;
        } else {
            current.previous.next = current.next;
        }
        if(current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }

    public void displayForward() {
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Link current = last;
        while(current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }
}
