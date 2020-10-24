package examples.generics;

import java.io.Serializable;

public class Manager extends Employee implements Serializable {
    private int bonus;
    private Employee secretary;

    public Manager(String name, int salary, int day, int month, int year) {
        super(name, salary, day, month, year);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }
}
