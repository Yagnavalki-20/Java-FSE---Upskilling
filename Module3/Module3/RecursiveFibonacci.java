import java.util.Scanner;

public class RecursiveFibonacci {

    public static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        do {
            System.out.print("Enter a non-negative integer: ");
            n = input.nextInt();
            if (n < 0) {
                System.out.println("Invalid input! Please try again.");
            }
        } while (n < 0);

        int fibNumber = fibonacci(n);
        System.out.printf("Fibonacci number at position %d is: %d%n", n, fibNumber);

        input.close();
    }
}
