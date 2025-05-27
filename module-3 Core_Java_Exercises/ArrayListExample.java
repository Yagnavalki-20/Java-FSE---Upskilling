import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.println("Enter names (type 'end' to stop):");
        while (true) {
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("end")) break;
            names.add(name);
        }

        System.out.println("Names entered:");
        for (String n : names) {
            System.out.println(n);
        }
    }
}
