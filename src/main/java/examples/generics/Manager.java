package examples.generics;

public class Manager extends Employee {
    private int bonus;

    public Manager(String name, int salary, int day, int month, int year) {
        super(name, salary, day, month, year);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
