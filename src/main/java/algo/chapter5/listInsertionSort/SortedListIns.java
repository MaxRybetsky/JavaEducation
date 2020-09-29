package algo.chapter5.listInsertionSort;

import algo.chapter5.firstLastList.Link;
import algo.chapter5.sortedList.SortedList;

public class SortedListIns extends SortedList {
    public SortedListIns(Link[] arr) {
        super();
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i].dData);
        }
    }
}
