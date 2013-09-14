package ch2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/12/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter an integer for seconds: ");
        int seconds = input.nextInt();

        int minutes = seconds / 60; // minutes in seconds
        int remainingSeconds = seconds % 60; // seconds remaining

        System.out.println(seconds + " seconds is " + minutes +
            " minutes and " + remainingSeconds + " seconds.");

    }
}
