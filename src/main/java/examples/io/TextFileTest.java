package examples.io;

import examples.generics.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class TextFileTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker",
                75000, 15, 12, 1987);
        staff[1] = new Employee("Harry Hacker",
                50000, 1, 10, 1989);
        staff[2] = new Employee("Tony Tester",
                40000, 15, 3, 1990);
        try (PrintWriter out = new PrintWriter("employee.dat")) {
            writeData(staff, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Scanner in = new Scanner(new FileInputStream("employee.dat"))) {
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    /**
     * Writes data about employees from
     * array to output stream
     *
     * @param employees array of employees data
     * @param out       stream of output data
     */
    private static void writeData(Employee[] employees,
                                  PrintWriter out) throws IOException {
        out.println(employees.length);
        for (Employee emp : employees) {
            writeEmployee(out, emp);
        }
    }

    /**
     * Reads employees data from scanner
     * stream to array
     *
     * @param in Scanner stream of input data
     * @return array of notes about employees
     */
    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    /**
     * Direct employees data to
     * output stream
     *
     * @param out output stream
     * @param e   an Employee object to write
     */
    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|"
                + e.getSalary() + "|"
                + e.getDataOfEmp());
    }

    /**
     * Reads data about employees from buffered
     * stream of input data
     *
     * @param in Stream of input data
     * @return an new Employee object
     */
    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDay = LocalDate.parse(tokens[2]);
        int year = hireDay.getYear();
        int month = hireDay.getMonthValue();
        int day = hireDay.getDayOfMonth();
        return new Employee(name, salary, day, month, year);
    }
}
