import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student ID and name (type 'done' to finish):");
        while (true) {
            System.out.print("Enter student ID: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            int id = Integer.parseInt(input);
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            studentMap.put(id, name);
        }

        System.out.print("Enter student ID to retrieve name: ");
        int searchId = scanner.nextInt();
        String studentName = studentMap.get(searchId);

        if (studentName != null) {
            System.out.println("Student with ID " + searchId + ": " + studentName);
        } else {
            System.out.println("No student found with ID " + searchId);
        }

        scanner.close();
    }
}
