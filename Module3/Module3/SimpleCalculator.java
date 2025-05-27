import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNum = input.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNum = input.nextDouble();

        System.out.print("Select operation (+, -, *, /): ");
        char op = input.next().charAt(0);

        double output;

        switch (op) {
            case '+':
                output = firstNum + secondNum;
                System.out.println("Result = " + output);
                break;

            case '-':
                output = firstNum - secondNum;
                System.out.println("Result = " + output);
                break;

            case '*':
                output = firstNum * secondNum;
                System.out.println("Result = " + output);
                break;

            case '/':
                if (secondNum != 0) {
                    output = firstNum / secondNum;
                    System.out.println("Result = " + output);
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;

            default:
                System.out.println("Invalid operation selected.");
        }

        input.close();
    }
}
