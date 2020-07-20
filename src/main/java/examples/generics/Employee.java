package examples.generics;

import java.time.LocalDate;

public class Employee {
    private String name;
    private int salary;
    private LocalDate dataOfEmp;

    public Employee(String name, int salary, int day, int month, int year) {
        this.name = name;
        this.salary = salary;
        this.dataOfEmp = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getDataOfEmp() {
        return dataOfEmp;
    }
}
