package algo.chapter5.interIterator;

import algo.chapter5.firstLastList.Link;

public class ListIterator {
    private Link current;
    private Link previous;
    private final LinkList ourList;

    public ListIterator(LinkList ourList) {
        this.ourList = ourList;
    }

    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(long dd) {
        Link link = new Link(dd);
        if(ourList.isEmpty()) {
            ourList.setFirst(link);
            current = link;
        } else {
            link.next = current.next;
            current.next = link;
            nextLink();
        }
    }

    public void insertBefore(long dd) {
        Link link = new Link(dd);
        if(previous == null) {
            link.next = ourList.getFirst();
            ourList.setFirst(link);
            reset();
        } else {
            link.next = previous.next;
            previous.next = link;
            current = link;
        }
    }

    public long deleteCurrent() {
        long value = current.dData;
        if(previous == null) {
            ourList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if(atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return value;
    }
}
