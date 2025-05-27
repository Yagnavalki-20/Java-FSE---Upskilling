import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess;

        do {
            System.out.print("Guess a number between 1 and 100: ");
            guess = scanner.nextInt();

            if (guess < numberToGuess)
                System.out.println("Too low!");
            else if (guess > numberToGuess)
                System.out.println("Too high!");
            else
                System.out.println("Correct!");
        } while (guess != numberToGuess);
    }
}
