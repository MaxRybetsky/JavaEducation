package examples.io;

public class SerialCloneTest {
    public static void main(String[] args)
            throws CloneNotSupportedException {
        Employee harry = new Employee("Harry Hacker",
                50000, 1, 10, 1989);
        Employee harry2 = (Employee) harry.clone();
        harry.raiseSalary(10);
        System.out.println(harry);
        System.out.println(harry2);
    }
}
