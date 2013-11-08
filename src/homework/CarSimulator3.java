import java.util.Scanner;

/**
 * Author:  Sean Herman
 * Date:    11/11/2013
 * HW#:     6
 * File:    CarSimulator3.java
 * Summary: Simulates the motion of 10 instances of the Car class on a 2-dimensional
 *      20x20 grid.
 * Assumptions: The assignment states that a color should be assigned randomly to
 *  the car in its constructor. That seemed really strange, so I decided to implement
 *  a public static getRandomColor() method instead for Car, which is passed as a
 *  parameter to the 3-param constructor (color, x, y). I could have created
 *  a 2rd 2-param constructor Car(int x, int y) and used the randomColor method there, but
 *  this solution felt more sensible, without being a deviation from the spirit of the
 *  exercise in my view.
 *  I also implemented a Position that is composed in Car, seeing that the assignment
 *  didn't call specifically for an X and Y attribute. I did, of course still
 *  implement Car-level getX() and getY() methods (which call the appropriate 
 *  Position instance method). I also moved my core event loop logic into main, reducing
 *  the number of superfluous methods. It still makes me feel really strange to put all
 *  my functionality into main() though, so I hope it's not a problem that there are still
 *  methods for things like printing prompts and the like.
 *
 */

public class CarSimulator3 {
    public static void main(String[] args) {
        // Introduce the program
        System.out.println("\nWelcome to Sean's car simulator.");
        System.out.println("This program simulates the movement of " +
            "10 cars across a 2-dimensional 20x20 grid.\n");

        // Create 10 Car objects. Color and position are random values.
        Car[] cars = new Car[10];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(Car.getRandomColor(), 
                            (int)(1 + Math.random() * Position.getRange()), 
                            (int)(1 + Math.random() * Position.getRange()));
        }

        // Show a summary of the cars array
        for (int i = 0; i < cars.length; i++) {
            System.out.printf("Car #%d (%s) begins at (%d,%d)\n", (i + 1), 
                                cars[i].getColorString(), cars[i].getX(), cars[i].getY());
        }

        System.out.println();

        Scanner input = new Scanner(System.in);

        // Point myCar to 1 of the 10 car[] objects
        Car myCar = selectCar(input, cars);
        System.out.println(myCar);

        String inputValue;
        // Prompt user for action
        showDoPrompt();
        // Get input from the user.
        inputValue = input.next();

        // Event loop
        while (!(inputValue.toLowerCase().equals("q"))) {
            
            // Determine which action to take on myCar
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
                        System.out.println("\nERROR: Switch on ignition first.\n");
                    }
                    break;

                case ("3"):
                    // 3 - select a car
                    myCar = selectCar(input, cars);
                    // Show the status of the car
                    System.out.println(myCar);
                    break;
            }

            // Prompt user for action
            showDoPrompt();
            // Get input from the user.
            inputValue = input.next();
        } // end event loop
        
        System.out.println("\nGoodbye. Thank you for using Sean's car simulator.\n");
    }

    public static void showDoPrompt() {
        System.out.println("What would you like to do?");
        System.out.println("  1: Turn the ignition on/off.");
        System.out.println("  2: Change the position of car.");
        System.out.println("  3: Switch cars.");
        System.out.println("  Q: Quit this program.");
    }

    /* Allows the user to switch to another car object in cars[] */
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
* Car class simulates a single car. Each car has a color, ignition (on/off), and
*   position (x, y). The position is represented by a composed Position object.
*
*/
class Car {
    private static char[] colorsAvailable = {'R', 'G', 'B', 'W', 'S'};
    private char color;
    private boolean ignition;
    private Position coords;

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
        // Returns a random char from colorsAvailable
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

    public void moveHorizontal(int x) {
        if (isIgnitionOn()) {
            coords.moveX(x);
        } else {
            System.out.println("\nERROR: Ignition is off. Switch on ignition first.\n");
        }
    }

    public void moveVertical(int y) {
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
        // Provides a string representation of the ignition status
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
        // Returns the status of a Car object, including its Color (String), 
        // ignition, and location (x,y). A grid representing the car's location
        // on a 2 dimensional plane is also included.
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
* The Position class represents a positon on a 2 dimensional plane from 1 - RANGE.
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
            System.out.printf("\nERROR: New position (%d,%d) is outside the " +
                                "permitted range (1-%d).\n\n", getX() + x, 
                                getY(), RANGE);
        }
    }

    public void moveY(int y) {
        if ((y + getY() <= Position.RANGE) && (y + getY() > 0)) {
            this.y += y;
        } else {
            System.out.printf("\nERROR: New position (%d,%d) is outside the " +
                                "permitted range (1-%d).\n\n", getX(), 
                                getY() + y, RANGE);
        }
    }
}