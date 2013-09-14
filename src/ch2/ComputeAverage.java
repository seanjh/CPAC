package ch2; /**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/12/13
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Scanner;

public class ComputeAverage {
    public static void main(String[] args) {
        // Create a new scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three numbers
        System.out.print("Enter three numbers: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        // Compute average
        double average = (num1 + num2 + num3) / 3;

        // Display the results
        System.out.println("The average of " + num1 + " " + num2
                + " " + num3 + " is " + average);
    }
}
