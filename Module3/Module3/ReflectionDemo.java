import java.lang.reflect.Method;

public class ReflectionDemo {
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            // Load class dynamically
            Class<?> clazz = Class.forName("ReflectionDemo");

            // Print all declared methods and their parameter types
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Declared methods:");
            for (Method method : methods) {
                System.out.print(method.getName() + "(");
                Class<?>[] paramTypes = method.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    System.out.print(paramTypes[i].getSimpleName());
                    if (i < paramTypes.length - 1) System.out.print(", ");
                }
                System.out.println(")");
            }

            // Create instance to invoke methods on
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // Get method "greet" with String parameter
            Method greetMethod = clazz.getDeclaredMethod("greet", String.class);

            // Invoke greet method dynamically
            greetMethod.invoke(instance, "World");

            // Get method "add" with two int parameters
            Method addMethod = clazz.getDeclaredMethod("add", int.class, int.class);

            // Invoke add method dynamically and print result
            Object result = addMethod.invoke(instance, 5, 3);
            System.out.println("Result of add(5, 3): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
