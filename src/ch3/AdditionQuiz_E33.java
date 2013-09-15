package ch3;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/15/13 5:37 PM
 * Addition Quiz presents users with 2 integers < 100. The user is asked to add these 2 numbers together.
 * The program reports whether or not the user answered the question correctly.
 */
public class AdditionQuiz_E33 {
    public static void main(String[] args) {
        System.out.print("Welcome to Sean's Addition Quiz!\n");
        System.out.println("This program will ask you to provide the sum of 2 integers, and report" +
                "\nwhether or not you've provided the correct answer.\n");

        int number1 = (int)(Math.random()*100);
        int number2 = (int)(Math.random()*100);

        System.out.print(number1 + " + " + number2 + " = ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        if (answer == (number1 + number2))
            System.out.println("Correct!");
        else
            System.out.println("Incorrect." +
                    "\n" + number1 + " + " + number2 + " = " + (number1 + number2));
    }
}
