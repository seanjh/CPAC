package ch3;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * CPAC
 * User: Sean
 * Date: 9/15/13 7:54 PM
 * This program applies Zeller's congruence to determine the
 * day of the week, given any Year, Month, and Day.
 */
public class Zeller {
    public static void main(String[] args) {
        System.out.println("This program determines the day of the week, " +
                "given any year, month, and day.");
        // Prompt user for the year.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter year (e.g., 2012): ");
        int year = input.nextInt();

        // Prompt user for the month.
        System.out.print("Enter month number (1-12): ");
        int month = input.nextInt();

        // Prompt user for the day of tvhe month.
        System.out.print("Enter the day of the month (1-31): ");
        int day = input.nextInt();

        // Normalize values.
        if (month <= 2) {
            year--;
            month += 12;
        }

        // Derive supporting values.
        int century = year / 100;
        int centuryYear = year % 100;

        // Apply Zeller's congruence to derive h (0-6 for Saturday-Friday)
        int zellerWeekdayInt = (day +
            (26 * (month + 1) / 10) +
            centuryYear +
            (centuryYear / 4) +
            (century / 4) +
            5 * century) % 7;

        // Display weekday name for given date.
        if (zellerWeekdayInt <= 6) {
            System.out.printf("%02d/%02d/%4d falls on a ", month, day, year);
                    //"\n" + month + "/" + day + "/" + year + " falls on a ");
            switch (zellerWeekdayInt) {
                case 0: System.out.print("Saturday"); break;
                case 1: System.out.print("Sunday"); break;
                case 2: System.out.print("Monday"); break;
                case 3: System.out.print("Tuesday"); break;
                case 4: System.out.print("Wednesday"); break;
                case 5: System.out.print("Thursday"); break;
                case 6: System.out.print("Friday"); break;
            }
         }
        else
            System.out.println("Error!");
    }
}
