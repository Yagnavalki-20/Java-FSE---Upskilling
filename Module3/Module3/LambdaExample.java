import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add("David");

        // Sort the list using a lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        System.out.println("Sorted list of names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
