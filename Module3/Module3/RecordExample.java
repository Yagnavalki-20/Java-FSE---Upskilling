import java.util.List;
import java.util.stream.Collectors;

public class RecordExample {
    // Define a record named Person with name and age
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        // Create instances of Person
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 30);
        Person p3 = new Person("Charlie", 20);

        // Print the persons
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Use records in a List
        List<Person> people = List.of(p1, p2, p3);

        // Filter based on age using Streams (age >= 25)
        List<Person> filtered = people.stream()
                                      .filter(person -> person.age() >= 25)
                                      .collect(Collectors.toList());

        System.out.println("People aged 25 and above:");
        filtered.forEach(System.out::println);
    }
}
