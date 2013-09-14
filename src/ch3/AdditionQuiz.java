package ch3;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/14/13 6:40 PM
 */
public class AdditionQuiz {
    public static void main(String[] args) {
        // Initialize input values.
        int number1 = (int)(System.currentTimeMillis() % 10);
        int number2 = (int)(System.currentTimeMillis() / 7 % 10);

        // Create a Scanner object.
        Scanner input = new Scanner(System.in);

        System.out.print(
            "What is " + number1 + " + " + number2 + "? ");

        int answer = input.nextInt();

        System.out.println(
            number1 + " + " + number2 + " = " + answer + " is " +
            (number1 + number1 == answer));
    }
}
