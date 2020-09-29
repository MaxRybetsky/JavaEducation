package algo.chapter5.interIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterIterApp {
    public static void main(String[] args) throws IOException {
        LinkList list = new LinkList();
        ListIterator iter1 = list.getIterator();
        long value;
        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);
        boolean f = true;
        while (f) {
            System.out.println("Enter first letter of show, reset,"
                    + "next, get, before, after, delete or exit: ");
            System.out.flush();
            int choice = getChar();
            switch (choice) {
                case 's':
                    if (!list.isEmpty()) {
                        list.displayList();
                    } else {
                        System.out.println("Empty");
                    }
                    break;
                case 'r':
                    iter1.reset();
                    break;
                case 'n':
                    if (!list.isEmpty() && !iter1.atEnd()) {
                        iter1.nextLink();
                    } else {
                        System.out.println("Can't go to next link");
                    }
                    break;
                case 'g':
                    if (!list.isEmpty()) {
                        System.out.println("Returned: "
                                + iter1.getCurrent().dData);
                    }
                    break;
                case 'b':
                    System.out.println("Enter value to insert:");
                    System.out.flush();
                    iter1.insertBefore(getInt());
                    break;
                case 'a':
                    System.out.println("Enter value to insert:");
                    System.out.flush();
                    iter1.insertAfter(getInt());
                    break;
                case 'd':
                    if (!list.isEmpty()) {
                        System.out.println("Deleted: "
                                + iter1.deleteCurrent());
                    } else {
                        System.out.println("Can't delete");
                    }
                    break;
                case 'e':
                    f = false;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static char getChar() throws IOException {
        return getString().charAt(0);
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
