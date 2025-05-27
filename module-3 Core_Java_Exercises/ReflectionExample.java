import java.lang.reflect.Method;

public class ReflectionExample {
    public static void greet() {
        System.out.println("Hello from reflection!");
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectionExample");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }

        Method greetMethod = clazz.getDeclaredMethod("greet");
        greetMethod.invoke(null);
    }
}
