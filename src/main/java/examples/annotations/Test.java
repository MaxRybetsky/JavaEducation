package examples.annotations;

public class Test {
    @MethodInfo(purpose = "print smth")
    public void printSmth() {
        System.out.println("smth");
    }
}
