import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortExample {
    public static void main(String[] args) {
        // Create a List of strings
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Mohan");
        names.add("Anita");
        names.add("Raj");
        names.add("Deepa");

        // Sort the list using Collections.sort() with a lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        // Display the sorted list
        System.out.println("Sorted list:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
