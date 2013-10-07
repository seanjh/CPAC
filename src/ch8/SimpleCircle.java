public class SimpleCircle {
    public static void main(String[] args) {
        // Create a new circle w/ radius 1
        SimpleCircleTest circle1 = new SimpleCircleTest();

        System.out.println("The area of the circle of radius " + 
            circle1.radius + " is " + circle1.getArea());


    }

}

class SimpleCircleTest {
    /** The radius of this circle */
    double radius;

    /** Construct a circle object */
    SimpleCircleTest() {
        radius = 1;
    }

    /** Construct a circle object */
    SimpleCircleTest(double newRadius) {
        radius = newRadius;
    }

    /** Return the area of this circle */
    double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return the perimeter of this circle */
    double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    void setRadius(double newRadius) {
        radius = newRadius;
    }
}