import java.util.*;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class PersonRecord {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Carol", 35)
        );

        people.forEach(System.out::println);

        List<Person> filtered = people.stream()
                                      .filter(p -> p.age() > 28)
                                      .collect(Collectors.toList());
        System.out.println("People older than 28: " + filtered);
    }
}
