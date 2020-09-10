package algo.chapter5.linkList;

public class LinkListApp {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(22, 2.99);
        linkList.insertFirst(44, 4.99);
        linkList.insertFirst(66, 6.99);
        linkList.insertFirst(88, 8.99);
        linkList.displayList();
        while(!linkList.isEmpty()) {
            Link aLink = linkList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
        }
        linkList.displayList();
    }
}
