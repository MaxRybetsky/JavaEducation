package exam.epam;

public class Seventh {
    static CoffeeSize ccs;
    public static void main(String[] args) {
        CoffeeSize cs = CoffeeSize.BIG;
        System.out.println(cs.HUGE);
        System.out.println(ccs.BIG);
    }
}

enum CoffeeSize {BIG, HUGE, LITTLE}
