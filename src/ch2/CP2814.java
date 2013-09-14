package ch2;

import java.lang.Math;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/12/13
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class CP2814 {
    public static void main(String[] args) {
        // 2.12
        System.out.println("25 / 4 is " + 25 / 4); // 6
        System.out.println("25 / 4.0 is " + 25 / 4.0); // 6.25
        System.out.println("3 * 2 / 4 is " + 3 * 2 / 4); // 1
        System.out.println("3.0 * 2 / 4 is " + 3.0 * 2 / 4); // 1.5

        // 2.13
        System.out.println(Math.pow(2, 3.5)); // 2^3.5

        // 2.14
        int m = 5, r = 7;
        System.out.println("Result: " + Math.pow((m * r), 2));
    }
}
