package examples.oca;

public class Test1 {
    public static final String m = "sd";

    public static void main(String[] args) {
        long x = 10;
        int y = 5;
        y *= x;
        System.out.println(y);
        String s = m;
        switch (s) {
            case "d":
                System.out.println("d");
                break;
            case m:
                System.out.println(m);
                break;
            default:
                System.out.println(s);
                break;
        }
        LOOP:
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j < 12; j++) {
                System.out.print(j + " ");
                if ((j % 7) == 0) {
                    System.out.println();
                    continue LOOP;
                }
            }
        }
        BLOCK:
        {
            System.out.println("Block");
        }
    }
}
