package ch2;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/12/13
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kilometers {
    public static void main(String[] args) {
        // Declare input values
        double miles = 100.0;
        final double KILOMETERS_PER_MILE = 1.609;

        // Convert miles to kilometers
        double kilometers = (miles * KILOMETERS_PER_MILE);

        // Display the result
        System.out.println(miles + " miles is equivalent to " + kilometers + " kilometers.");

    }
}
