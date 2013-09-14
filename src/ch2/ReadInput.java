package ch2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/12/13
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReadInput {
    public static void main(String[] args) {
        final double PI = 3.14159;

        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a radius
        System.out.print("Enter a number for radius: ");
        double radius = input.nextDouble();

        // Compute area
        double area = radius * radius * PI;

        // Display results
        System.out.println("The area for the circle of radius "
            + radius + " is " + area);
    }
}
