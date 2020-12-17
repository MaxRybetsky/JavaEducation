package examples.reflexion.lesson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        Class personClass1 = Person.class;
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("examples.reflexion.lesson.Person");
        Method[] methods = personClass1.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ", "
                    + method.getReturnType() + ", "
                    + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("====================");
        Field[] fields = personClass1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ", " + field.getType());
        }
        System.out.println("====================");
        Annotation[] annotations = personClass1.getAnnotations();
        for (Annotation annotation : annotations) {
            if(annotation instanceof Author) {
                System.out.println("Yes");
            }
        }
    }
}
