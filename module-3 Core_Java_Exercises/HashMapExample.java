import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 3 student ID-name pairs:");
        for (int i = 0; i < 3; i++) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume newline
            System.out.print("Name: ");
            String name = scanner.nextLine();
            students.put(id, name);
        }

        System.out.print("Enter an ID to search: ");
        int searchId = scanner.nextInt();
        if (students.containsKey(searchId)) {
            System.out.println("Name: " + students.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }
    }
}
