package examples.interfaces;

public class MyClass implements B {
    private String id;

    public MyClass(String id) {
        this.id = id;
    }
    @Override
    public void m() {

    }

    @Override
    public String toString() {
        return id;
    }
}
