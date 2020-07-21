package examples.collections;

import examples.generics.Employee;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("11", new Employee("Amy Lee"));
        staff.put("22", new Employee("Von Bar"));
        staff.put("33", new Employee("Morgenstein"));
        staff.put("44", new Employee("Till Lindeman"));
        System.out.println(staff);
        staff.remove("22");
        staff.put("11", new Employee("No Amy more"));
        System.out.println(staff.get("11"));
        staff.forEach((k, v) -> System.out.println("key=" + k + "; v=" + v));
    }
}
