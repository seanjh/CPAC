package ch2;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 9/11/13
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class AreaCircle {
    public static void main(String[] args) {
        double radius;
        double area;

        // read in the circle's radius
        // assign a radius
        radius = 20; // radius is now 20

        // compute the area using area = radius * radius * pi
        area = radius * radius * 3.14159;

        // display the result
        System.out.println("The area for the circle of radius " +
            radius + " is " + area);
    }
}
