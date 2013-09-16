package ch3;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * CPAC
 * User: Sean
 * Date: 9/15/13 7:05 PM
 * This program calculates the 10-digit checksum value for an ISBN-10 code.
 */
public class CheckISBN10 {
    public static void main(String[] args) {
        // Introduce the program
        System.out.print("This program calculates the 10th digit checksum" +
                "\n value for a ISBN-10 number.");
        // Prompt user for the first 9 digits (as integer)
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the first 9 digits of the ISBN number: ");
        int isbn = input.nextInt();

        // Calculate the 10th digit checksum
        int checksum =
                ((isbn % 10) * 9 + // 9th
                (isbn % 100) / 10 * 8 + // 8th
                (isbn % 1000) / 100 * 7 + // 7th
                (isbn % 10000) / 1000 * 6 + // 6th
                (isbn % 100000) / 10000 * 5 + // 5th
                (isbn % 1000000) / 100000 * 4 + // 4th
                (isbn % 10000000) / 1000000 * 3 + // 3rd
                (isbn % 100000000) / 10000000 * 2 + // 2nd
                (isbn % 1000000000) / 100000000) // 1st
                % 11;

        // Display the full ISBN-10 number
        System.out.println("The ISBN-10 number is " + isbn +
                (checksum < 10 ? (char)(checksum + 48) : 'X'));
    }
}
