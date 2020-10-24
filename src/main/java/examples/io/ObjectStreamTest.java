package examples.io;

import examples.generics.Employee;
import examples.generics.Manager;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        Employee harry = new Employee("Harry Hacker",
                50000, 1, 10, 1989);
        Manager carl = new Manager("Carl Cracker",
                75000, 15, 12, 1987);
        carl.setSecretary(harry);
        Manager tony = new Manager("Tony Tester",
                40000, 15, 3, 1990);
        tony.setSecretary(harry);
        Employee[] staff = new Employee[3];
        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("employee.dat"))) {
            out.writeObject(staff);
        }
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("employee.dat"))) {
            Employee[] newStaff = (Employee[]) in.readObject();
            newStaff[1].raiseSalary(10);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }
}
