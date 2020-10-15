package examples.types;

public class Type extends A implements S {
    public static void main(String[] args) {
        Type t = new Type();
        t.say();
    }
}

class A {
    public void say(){
        System.out.println("Class");
    }
}

interface S{
    default void say() {
        System.out.println("Inter");
    }
}
