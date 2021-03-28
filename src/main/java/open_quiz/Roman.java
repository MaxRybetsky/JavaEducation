package open_quiz;

    import java.util.HashMap;
    import java.util.Map;

public class Roman {
    static Map<String, Integer> basis = new HashMap<>();

    static {
        basis.put("I", 1);
        basis.put("IV", 4);
        basis.put("V", 5);
        basis.put("IX", 9);
        basis.put("X", 10);
        basis.put("XL", 40);
        basis.put("L", 50);
        basis.put("XC", 90);
        basis.put("C", 100);
        basis.put("CD", 400);
        basis.put("D", 500);
        basis.put("CM", 900);
        basis.put("M", 1000);
    }

    public static int convert(String roman) {
        boolean isNextUsed = false;
        int sum = 0;
        for (int i = 0; i < roman.length()-1; i++) {
            String current = String.valueOf(roman.charAt(i));
            String next = String.valueOf(roman.charAt(i + 1));
            switch (current) {
                case "I":
                    if ("V".equals(next)) {
                        sum += basis.get("IV");
                        isNextUsed = true;
                    } else if ("X".equals(next)) {
                        sum += basis.get("IX");
                        isNextUsed = true;
                    } else {
                        sum += basis.get("I");
                        isNextUsed = false;
                    }
                    break;
                case "X":
                    if ("L".equals(next)) {
                        sum += basis.get("XL");
                        isNextUsed = true;
                    } else if ("C".equals(next)) {
                        sum += basis.get("XC");
                        isNextUsed = true;
                    } else {
                        sum += basis.get("X");
                        isNextUsed = false;
                    }
                    break;
                case "C":
                    if ("D".equals(next)) {
                        sum += basis.get("CD");
                        isNextUsed = true;
                    } else if ("M".equals(next)) {
                        sum += basis.get("CM");
                        isNextUsed = true;
                    } else {
                        sum += basis.get("C");
                        isNextUsed = false;
                    }
                    break;
                default:
                    sum += basis.get(current);
                    isNextUsed = false;
                    break;
            }
            if(isNextUsed) {
                i++;
            }
        }
        if(!isNextUsed) {
            sum += basis.get(roman.substring(roman.length()-1));
        }
        return sum;
    }

    public static void main(String[] args) {
        String r = "MDCCCLIV";
        System.out.println(convert(r));
    }
}
