import java.util.Scanner;

/**
 * Name: Sean Herman
 * Date: 9/22/2013
 * Summary: This program display all leap years between 2001 and 2100.
 */

public class LeapYearRange {
	/** Main method */
    public static void main(String[] args) {
 		// Introduce the program
		System.out.println("This program displays all the leap years between " +
			"2 input years (>0).");

		// Create a new Scanner
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the starting year: ");
		int firstYear = input.nextInt();
		System.out.print("Enter the ending year: ");
		int lastYear = input.nextInt();

		// Initialize output year value and column counter
		int thisYear = firstYear;
		int i = 0;
		
		// Loop over year range, checking for leap years
		while (thisYear < lastYear) {
			if (i == 10) {
				System.out.println(); // print a new line after 10 output values
				i = 0;
			}
			
			if ( ((thisYear % 4 == 0) && (thisYear % 100 != 0)) || thisYear % 400 == 0 ) {
				i++; // count the added column
				System.out.printf("%-5d", thisYear); // print the leap year
			}
			
			thisYear++;
		}
		System.out.println();
    }
}
