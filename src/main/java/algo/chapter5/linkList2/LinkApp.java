package algo.chapter5.linkList2;

public class LinkApp {
    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.insertFirst(22, 2.99);
        ll.insertFirst(44, 4.99);
        ll.insertFirst(66, 6.99);
        ll.insertFirst(88, 8.99);
        ll.displayList();
        Link f = ll.find(44);
        if(f != null) {
            System.out.println(f.iData);
        } else {
            System.out.println("Can't find");
        }
        Link d = ll.delete(66);
        System.out.println(d != null ? "Found " + d.iData : "Can't find");
        ll.displayList();
    }
}
