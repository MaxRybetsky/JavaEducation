package examples.some;

import java.util.Arrays;

public class TestClass {
    public Some[] items = {
            new Some(2),
            new Some(3),
            new Some(4),
            new Some(5)
    };

    public Some meth(int key) {
        for (Some item : items) {
            if (key == item.ch) {
                return item;
            }
        }
        return null;
    }

    public void nuller() {
        Arrays.fill(items, null);
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        System.out.println(Arrays.toString(tc.items));
        Some s = tc.meth(4);
        s.ch = 555;
        System.out.println(Arrays.toString(tc.items));
        tc.nuller();
        System.out.println(Arrays.toString(tc.items));
    }
}

class Some {
    public int ch;

    public Some(int ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return ch + "";
    }

    public int mm() {
        String s = "1";
        return s.hashCode();
    }
}
