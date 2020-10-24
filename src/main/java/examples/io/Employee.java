package examples.io;

import java.time.LocalDate;

/**
 * {@code Employee} class for {@code SerialCloneable}
 * class extending
 */
public class Employee extends SerialCloneable {
    private String name;
    private double salary;
    private LocalDate dataOfEmp;

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

    /**
     * Raise salary of this employee
     * @param percent Percent of salary raise
     */
    public void raiseSalary(double percent) {
        salary += salary * percent / 100;
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
