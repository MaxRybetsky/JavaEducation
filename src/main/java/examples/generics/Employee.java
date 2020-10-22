package examples.generics;

import java.time.LocalDate;

public class Employee {
    public static final int NAME_SIZE = 40;
    public static final int RECORD_SIZE = 100;

    private String name;
    private double salary;
    private LocalDate dataOfEmp;

    public Employee() {
        this("No name");
    }

    public Employee(String name) {
        this(name, 0, 1, 1, 2000);
    }

    public Employee(String name, double salary, int day, int month, int year) {
        this.name = name;
        this.salary = salary;
        this.dataOfEmp = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDataOfEmp() {
        return dataOfEmp;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", salary=" + salary
                + ", dataOfEmp=" + dataOfEmp
                + '}';
    }
}
