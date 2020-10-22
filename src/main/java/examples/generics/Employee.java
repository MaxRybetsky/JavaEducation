package examples.generics;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private LocalDate dataOfEmp;

    public Employee(String name) {
        this(name, 5000, 12, 12, 2012);
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
