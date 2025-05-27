import java.util.List;
import java.util.stream.Collectors;

public class RecordExample {
    // Define a record named Person with name and age
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        // Create instances of Person
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 22);
        Person p3 = new Person("Charlie", 25);

        // Print the instances
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Use records in a List
        List<Person> people = List.of(p1, p2, p3);

        // Filter people older than 23 using Streams
        List<Person> filtered = people.stream()
            .filter(person -> person.age() > 23)
            .collect(Collectors.toList());

        System.out.println("\nPeople older than 23:");
        filtered.forEach(System.out::println);
    }
}
