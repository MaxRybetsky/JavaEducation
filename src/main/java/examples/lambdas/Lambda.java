package examples.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 0);
        integers.forEach(lambdaWrapper(i -> System.out.println(50 / i)));
    }

    static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException ex) {
                System.out.println("Arithmetic Error" + ex.getMessage());
            }
        };
    }
}
