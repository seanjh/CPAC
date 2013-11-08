package homework;

import java.util.Scanner;

//package HW6;

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
        // Introduce the program
        System.out.println();
        System.out.println("Welcome to Sean's car simulator.");
        System.out.println("This program simulates the movement of " +
            "10 cars across a 2-dimensional 20x20 grid.");
        System.out.println();

        // Create 10 Car objects with random inputs for color and Position (x,y)
        Car[] cars = new Car[10];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(Car.getRandomColor(), 
                            (int)(1 + Math.random() * Position.getRange()), 
                            (int)(1 + Math.random() * Position.getRange()));
        }

        for (int i = 0; i < cars.length; i++) {
            System.out.printf("Car #%d (%s) begins at (%d,%d)\n", (i + 1), 
                                cars[i].getColorString(), cars[i].getX(), cars[i].getY());
        }

        System.out.println();

        driveCars(cars);
        
        System.out.println();
        System.out.println("Quitting program. Thank you for using Sean's car simulator.");
        System.out.println();
    }

    public static void driveCars(Car[] cars) {
        Scanner input = new Scanner(System.in);
        String inputValue = "";

        Car myCar = selectCar(input, cars);
        System.out.println(myCar);

        while (!(inputValue.toLowerCase().equals("q"))) {
            // Prompt user for action
            showDoPrompt();

            // Get input from the user.
            inputValue = input.next();

            switch (inputValue.toLowerCase()) {
                case ("1"):
                    // 1 - change ignition
                    myCar.switchIgnition();
                    break;

                case ("2"):
                    // 2 - change position of car
                    if (myCar.isIgnitionOn()) {
                        moveCar(input, myCar);
                        // Show the status of the car
                        System.out.println(myCar);
                    } else {
                        // Dummy call to move vertical, which triggers ignition error.
                        myCar.moveVertical(0);
                    }
                    break;

                case ("3"):
                    // 3 - select a car
                    myCar = selectCar(input, cars);
                    // Show the status of the car
                    System.out.println(myCar);
                    break;
            }
        }
    }

    public static void showDoPrompt() {
        System.out.println("What would you like to do?");
        System.out.println("  1: Turn the ignition on/off.");
        System.out.println("  2: Change the position of car.");
        System.out.println("  3: Switch cars.");
        System.out.println("  Q: Quit this program.");
    }

    public static Car selectCar(Scanner input, Car[] cars) {
        int index;

        // Prompt the user to select a car
        System.out.print("Which car would you like to use (1-" +
                cars.length + ")? ");
        index = input.nextInt();

        if (index < 1 || index > cars.length) {
            System.out.println("\nERROR: Invalid entry. Defaulting to Car #1.\n");
            index = 1;
        }
        
        // User input is from 1-length. Subtract 1 to accomodate the array.
        return cars[index - 1];
    }

    public static void moveCar(Scanner input, Car myCar) {
        // Prompt the user to specify a direction
        showMoveDirectionPrompt();
        String inputValue = input.next();
        int distance;

        switch (inputValue.toLowerCase()) {
            case ("h"):
                System.out.print("How far (negative value to move left)? ");
                distance = input.nextInt();
                myCar.moveHorizontal(distance);
                break;
            case ("v"):
                System.out.print("How far (negative value to move up)? ");
                distance = input.nextInt();
                myCar.moveVertical(distance);
                break;
            default:
                System.out.println("\nERROR: Invalid entry.\n");
        }
    }

    public static void showMoveDirectionPrompt() {
        System.out.println("In which direction would you like to move the car?");
        System.out.println("  H: horizontal");
        System.out.println("  V: vertical");
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
            System.out.println("\nERROR: Ignition is off. Switch on ignition first.\n");
        }
    }

    public void moveHorizontal(int y) {
        if (isIgnitionOn()) {
            coords.moveY(y);
        } else {
            System.out.println("\nERROR: Ignition is off. Switch on ignition first.\n");
        }
    }

    public void switchIgnition() {
        System.out.println("\nSwitching the ignition on.\n");
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
        output.append("Color:\t\t" + getColorString() + "\n");
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
    private static final int RANGE = 20;
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
        return RANGE;
    }

    public void moveX(int x) {
        if ((x + getX() <= Position.RANGE) && (x + getX() > 0)) {
            this.x += x;
        } else {
            System.out.printf("ERROR: Position is outside the permitted range " + 
                                "(1-%d).\n", RANGE);
        }
    }

    public void moveY(int y) {
        if ((y + getY() <= Position.RANGE) && (y + getY() > 0)) {
            this.y += y;
        } else {
            System.out.printf("ERROR: Position is outside the permitted range " + 
                                "(1-%d).\n", RANGE);
        }
    }
}