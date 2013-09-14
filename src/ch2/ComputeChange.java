package ch2;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 9/14/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputeChange {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt user for total amount in dollars & cents.
        System.out.println("Please input a total amount (e.g., $50.34): $");
        int totalAmount = (int)(input.nextDouble() * 100); // Convert input to pennies

        // Calculate dollars
        int totalDollars = totalAmount / 100;
        int totalRemaining = totalAmount % 100;

        // Calculate quarters
        int totalQuarters = totalRemaining / 25;
        totalRemaining = totalRemaining % 25;

        // Calculate dimes
        int totalDimes = totalRemaining / 10;
        totalRemaining = totalRemaining % 10;

        // Calculate nickels
        int totalNickels = totalRemaining / 5;
        totalRemaining = totalRemaining % 5;

        // Display results
        System.out.println("Your amount $" + totalAmount / 100.0 +
            " consists of " +
            totalDollars + " dollars, " +
            totalQuarters + " quarters, " +
            totalDimes + " dimes, " +
            totalNickels + " nickels, and " +
            totalRemaining + " pennies.");



        // Convert input into cents
        // Calculate dollars (e.g., 535 / 100 = 5)
        // Update remainder (e.g., 535 % 100 = 35)
        // Calculate quarters in remainder (e.g. 35 / 25 = 1)
        // Update remainder (e.g., remainder = remainder % 25)
        // Repeat for dimes, nickels, pennies
    }
}
