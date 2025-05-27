import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks out of 100: ");
        
        if (scanner.hasNextInt()) {
            int marks = scanner.nextInt();

            if (marks >= 0 && marks <= 100) {
                String grade = calculateGrade(marks);
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
            }
        } else {
            System.out.println("Invalid input! Please enter a valid integer.");
        }

        scanner.close();
    }

    private static String calculateGrade(int marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
