package HW6;

/**
 * Author:  Sean Herman
 * Date:    etc.
 * HW#:     etc.
 * File:    etc.
 * Summary: etc.
 * Notes:   etc.
 *
 */

public class CarSimulator3 {
    public static void main(String[] args) {
        // Creating 10 Car objects using the default constructor
        Car[] cars = new Car[10];
        for (int i = 0; i < cars.length; i++) {
            int x = (int)(1 + Math.random() * 20);
            int y = (int)(1 + Math.random() * 20);
            System.out.println("Coords (" + x + "," + y + ")");
            cars[i] = new Car(Car.getRandomColor(), x, y);
            System.out.println(cars[i]);
        }
    }
}

/**
* Car
*
*/
class Car {
    private static char[] colorsAvailable = {'R', 'G', 'B', 'W', 'S'};
    private char color;
    private boolean ignition;
    private Position coords;
    private static int maxCoord = 20;

    /* Default no-arg constructor. */
    public Car() {
        this('R', 1, 1);
    }

    /* 3-arg Constructor */
    public Car(char color, int x, int y) {
        this.color = color;
        ignition = false;
        coords = new Position(x, y);
    }

    /* Reports the list of possible colors */
    public static char[] getColorsAvailable() {
        return colorsAvailable;
    }

    public static char getRandomColor() {
        return colorsAvailable[(int)(Math.random() * 5)];
    }

    public char getColor() {
        return color;
    }

    public String getColorString() {
        switch (color) {
            case 'R':
                return "Red";
            case 'G':
                return "Green";
            case 'B':
                return "Blue";
            case 'W':
                return "White";
            case 'S':
                return "Silver";
            default:
                return "ERROR";
        }
    }

    public boolean isIgnitionOn() {
        return ignition;
    }

    public void moveVertical(int x) {
        if (isIgnitionOn()) {
            coords.moveX(x);
        } else {
            System.out.println("ERROR: Ignition is off. Switch on ignition first.");
        }
    }

    public void moveHorizontal(int y) {
        if (isIgnitionOn()) {
            coords.moveY(y);
        } else {
            System.out.println("ERROR: Ignition is off. Switch on ignition first.");
        }
    }

    public void switchIgnition() {
        this.ignition = !ignition;
    }

    private String getIgnitionStatus() {
        if (ignition) {
            return "On";
        } else {
            return "Off";
        }
    }

    public int getX() {
        return coords.getX();
    }

    public int getY() {
        return coords.getY();
    }

    @Override public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(this.getClass().getName() + " Object Information\n");
        output.append("Color:\t" + getColorString() + "\n");
        output.append("Ignition:\t" + getIgnitionStatus() + "\n");
        output.append("Location:\t(" + getX() + "," + getY() + ")\n\n");
        
        /* Builds the overhead grid string */
        for (int y = 1; y <= Position.getRange(); y++) {
            for (int x = 1; x <= Position.getRange(); x++) {
                if (getX() == x && getY() == y) {
                    output.append(" " + color);
                } else {
                    output.append(" -");
                }
            }
            output.append("\n"); // Add newline when x hits Position.range
        }

        return output.toString();
    }
}

/**
* Position
*
*/
class Position {
    private static int range = 20;
    private int x = 0;
    private int y = 0;

    public Position() {
        this(1, 1);
    }

    public Position(int x, int y) {
        moveX(x);
        moveY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getRange() {
        return range;
    }

    public void moveX(int x) {
        if ((x + getX() <= Position.range) && (x + getX() > 0)) {
            this.x += x;
        } else {
            System.out.printf("ERROR: Coordinates are outside the permitted range " + 
                                "(1-%d).\n", range);
        }
    }

    public void moveY(int y) {
        if ((y + getY() <= Position.range) && (y + getY() > 0)) {
            this.y += y;
        } else {
            System.out.printf("ERROR: Coordinates are outside the permitted range " + 
                                "(1-%d).\n", range);
        }
    }
}