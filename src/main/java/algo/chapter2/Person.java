package algo.chapter2;

public class Person {
    private final String lastName;
    private final String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.println("Last name: " + lastName
                + ", First name: " + firstName
                + ", Age: " + age);
    }

    public String getLastName() {
        return lastName;
    }
}
