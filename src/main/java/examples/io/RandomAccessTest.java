package examples.io;

import examples.generics.Employee;

import java.io.*;
import java.time.LocalDate;

public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker",
                75000, 15, 12, 1987);
        staff[1] = new Employee("Harry Hacker",
                50000, 1, 10, 1989);
        staff[2] = new Employee("Tony Tester",
                40000, 15, 3, 1990);
        try (DataOutputStream out = new DataOutputStream(
                new FileOutputStream("employee.dat"))) {
            for (Employee e : staff) {
                writeData(out, e);
            }
        }
        try (RandomAccessFile in = new RandomAccessFile("employee.dat", "r")) {
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    /**
     * Writes employees info in
     * output stream
     *
     * @param out output stream
     * @param e   an employee
     * @throws IOException if process was interrupted due to
     *                     any IO error
     */
    public static void writeData(DataOutput out,
                                 Employee e) throws IOException {
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());
        LocalDate hireDay = e.getDataOfEmp();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }

    /**
     * Reads employees info from
     * input stream
     *
     * @param in input stream
     * @return returns an employee
     * @throws IOException if process was interrupted due to
     *                     any IO error
     */
    public static Employee readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, d, m, y);
    }
}
