package ch3;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/15/13 2:43 PM
 */
public class LeapYEar {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year (e.g., 1951): ");
        int year = input.nextInt();

        // Test input year.
        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || year % 400 == 0;

        // Display the result
        if (isLeapYear)
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " is NOT a leap year.");
    }
}
