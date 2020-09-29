package algo.chapter5.listInsertionSort;

import algo.chapter5.firstLastList.Link;

public class ListInsertionSortApp {
    public static void main(String[] args) {
        int size = 10;
        Link[] arr = new Link[size];
        for (int i = 0; i < size; i++) {
            int n = (int)(Math.random() * 99);
            Link link = new Link(n);
            arr[i] = link;
            System.out.print(n + " ");
        }
        System.out.println();
        SortedListIns ins = new SortedListIns(arr);
        for (int i = 0; i < size; i++) {
            arr[i] = ins.remove();
            System.out.print(arr[i].dData + " ");
        }
    }
}
