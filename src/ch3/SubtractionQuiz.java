package ch3;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/15/13 1:30 PM
 */
public class SubtractionQuiz {
    public static void main(String[] args) {
        // 1. Generate 2 random single-digit integers
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);

        // 2. If number1 < number2, swap values to ensure positive result
        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        // 3. Prompt the student to answer "What is number 1 - number2?"
        System.out.print("What is " + number1 + " - " + number2 + "? ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        // 4. Grade the answer and display the result
        if (number1 - number2 == answer)
        System.out.println("You are correct!");
        else {
            System.out.println("Your answer is incorrect\n" +
                number1 + " - " + number2 + " is " + (number1 - number2));
        }
    }
}
