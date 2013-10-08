public class SimpleCircle {
    public static void main(String[] args) {
        // Create a new circle w/ radius 1
        SimpleCircle circle1 = new SimpleCircle();

        System.out.println("The area of the circle of radius " + 
            circle1.radius + " is " + circle1.getArea());

        SimpleCircle circle2 = new SimpleCircle(15);

        System.out.println("The area of the circle of radius " + 
            circle2.radius + " is " + circle2.getArea());

        circle2.setRadius(50);

        System.out.println("The area of the circle of radius " + 
            circle2.radius + " is " + circle2.getArea());


    }

    /** The radius of this circle */
    double radius;

    /** Construct a circle object */
    SimpleCircle() {
        radius = 1;
    }

    /** Construct a circle object */
    SimpleCircle(double newRadius) {
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