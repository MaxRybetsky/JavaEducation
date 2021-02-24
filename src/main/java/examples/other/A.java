package examples.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A implements Inter {
    @Override
    public void meth() {
        System.out.println("meth in A");
    }

    public static void main(String[] args) {
        O[] ar = {new O(), new O(), new O(), new O()};
        System.out.println(Arrays.toString(ar));
        for (O elem : ar) {
            elem.per = 14;
        }
        System.out.println(Arrays.toString(ar));
        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(1,2);
        System.out.println(i);
    }
}

class O {
    public int per = 13;

    @Override
    public String toString() {
        return String.valueOf(per);
    }
}
