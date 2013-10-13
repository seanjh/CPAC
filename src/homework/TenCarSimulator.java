/**
 * Author:   Sean Herman
 * Date:     10/13/2013
 * HW#:      #04
 * File:	 TenCarSimulator.java
 * Summary:  Simulates the movement and behavior of a 10 cars in a 2-dimensional
 *  plane. Each car's attributes include its color, its position (x,y) , and its
 *  ignition state (on/off). Users may control the ignition, and move the cars
 *  around witin a 20x20 grid. After each move, the position of the selected car 
 *  is displayed.
 *
 * Notes:    I decided to stored each car in a String array. Preserving each car in its 
 * own array naturally presented some unique challenges. Adding or updating an 
 * individual car's attributes, or passing those attributes as parameters, 
 * required conversions between the original attribute type and the String. 
 * The class email provided an alternative, storing each set of attributes in 
 * its own array, but I feel my approach, while far from perfect (it's clear 
 * at this point that we're heading towards the ideal object-oriented solution) 
 * has the advantage of creating "object-like" arrays, storing different 
 * different types of values. If I'm forced to use arrays, I feel it's best to 
 * mimic that object-oriented style, and establish a single array for each car.
 */

import java.util.Scanner;

public class TenCarSimulator {
    public static void main(String[] args) {
        // Introduce the program
        System.out.println();
        System.out.println("Welcome to Sean's car simulator.");
        System.out.println("This program simulates the movement of" +
            "10 cars across a 2-dimensional 20x20 grid.");
        System.out.println();

        // Create the array of cars
        String[][] cars = new String[10][4];
        
        // Randomly assign attributes to each car
        int[] position = new int[2];
        for (int i = 0; i < cars.length; i++) {
            randomPosition(position);
            updateOneCar(cars[i], false, assignColor(), position);
        }

        // Show the starting position for each car.
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Car #" + (i + 1) + " (" + 
                                fullColor(cars[i][1].charAt(0)) + ")" +
                                 " begins at (" + Integer.parseInt(cars[i][2]) + 
                                 "," + Integer.parseInt(cars[i][3]) + ")");
        }
        
        System.out.println();

        driveCar(cars);
    } // end main

    public static void randomPosition(int[] position) {
        for (int i = 0; i < position.length; i++) {
            position[i] = (int) (Math.random() * 20 + 1);
        }
    }

    public static char assignColor() {
        // allColors represents the range of possible car colors
        char[] allColors = {'R', 'G', 'B', 'W', 'S'};
        return allColors[(int)(Math.random() * 5)];
    }

    public static void updateOneCar(String[] car, boolean ignition, char color, 
                                        int[] position) {
        // Store the various attributes as String values in an Array.
        car[0] = Boolean.toString(ignition);
        car[1] = Character.toString(color);
        car[2] = Integer.toString(position[0]);
        car[3] = Integer.toString(position[1]);
    }

    public static void driveCar(String[][] cars) {
        // In/out and flow controls
        Scanner input = new Scanner(System.in);
        String inputValue;
        boolean quitter;
        
        // 1 car temp variables variables
        boolean ignition;
        char color;
        int[] position = new int[2];
        int carIndex;

        // Prompt user to specify a car
        carIndex = selectCar(cars.length, input);

        do {
            // Pull the appropriate car attributes into the temp variables
            ignition = Boolean.parseBoolean(cars[carIndex][0]);
            color = cars[carIndex][1].charAt(0);
            position[0] = Integer.parseInt(cars[carIndex][2]);
            position[1] = Integer.parseInt(cars[carIndex][3]);

            // Show the user the selected car's attributes (no overhead yet)
            displayStatus(carIndex ,ignition, color, position, false);
            System.out.println();

            // Prompt user for action
            showDoPrompt();

            // Get input from the user.
            inputValue = input.next();
            System.out.println();
            quitter = (inputValue.equals("Q") || inputValue.equals("q"));

            // Check the input value.
            if (inputValue.equals("1")) { // Switch ignition.
                ignition = switchIgnition(ignition);
                // Sync this change with the original Array
                cars[carIndex][0] = Boolean.toString(ignition);
                System.out.println();

            } else if (inputValue.equals("2")) { // Change position.

                if (ignition) {
                    changePosition(carIndex, ignition, color, position, input);
                    updateOneCar(cars[carIndex], ignition, color, position);
                
                } else {
                    System.out.println("ERROR: You must turn on the ignition first!");
                    System.out.println();
                }

            } else if (inputValue.equals("3")) {
                // Prompt user to specify a car
                carIndex = selectCar(cars.length, input);

            } else if (!quitter) { // unrecognized entry
                System.out.println("ERROR: Invalid selection.");
                System.out.println();
            }

        } while(!quitter);
    } // end driveCar

    public static int selectCar(int total, Scanner input) {
        String inputValue;
        int index;
        boolean invalid;

        do {
            System.out.print("Which car would you like to use (1-" +
                total + ")? ");
            // Get input as a String
            inputValue = input.next();

            // Validate input to ensure the proper type and 
            // that the value is within the 1-total range.
            invalid = checkCar(inputValue, total);

        } while(invalid);

        index = Integer.parseInt(inputValue);

        return (index - 1);
    }

    public static boolean checkCar(String inputValue, int total) {
        // Initialize error checks to false
        boolean badType = false;
        boolean outOfRange = false;
        int index;
        
        try {
                index = Integer.parseInt(inputValue);
                outOfRange = (index > total || index < 1);
                
                if (outOfRange) {
                System.out.println("ERROR: Selection out of range!");
                }

            } catch (NumberFormatException e) {
                badType = true;
                System.out.println("ERROR: Invalid input!");
            }

        // If either is true, return true
        return (outOfRange || badType);
    }

    public static void showDoPrompt() {
        System.out.println("What would you like to do?");
        System.out.println("  1: Turn the ignition on/off.");
        System.out.println("  2: Change the position of car.");
        System.out.println("  3: Switch cars.");
        System.out.println("  Q: Quit this program.");
    }

    public static boolean switchIgnition(boolean ignition) {
        ignition = !ignition;

        System.out.print("Switching the ignition " + ignitionState(ignition));
        System.out.println();

        return ignition;
    }

    public static String ignitionState(boolean ignition) {
        String state;

        if (ignition)
            state = "on";
        else
            state = "off";

        return state;
    }

    public static void changePosition(int carIndex, boolean ignition, char color, int[] position,
                                      Scanner input) {
        int moveValue;
        boolean horizontalMove;
        String inputValue;
        int[] move = new int[2];

        // Prompt the user to specify the direction
        showMoveDirectionPrompt();
        inputValue = input.next();
        System.out.println();

        if (validDirection(inputValue)) {
            // Save the direction
            horizontalMove = inputValue.equals("H") || inputValue.equals("h");

            // Prompt the user to specify how far
            showHowFarPrompt(horizontalMove);
            inputValue = input.next();
            System.out.println();
            moveValue = Integer.parseInt(inputValue);

            // Initialize my x (move[0]) and y (move[1])
            if (horizontalMove) {
                move[0] = moveValue; // move x, not y
                move[1] = 0;
            } else {
                move[0] = 0;
                move[1] = moveValue; // move y, not x
            }

            // Now we can actually move the car.
            doMove(carIndex, ignition, color, position, move);
        } else { // end if(validDirection())
            System.out.println("ERROR: Invalid direction!");
            System.out.println();
        }
    } // end changePosition

    public static boolean validDirection(String input) {
        return (input.equals("H") || input.equals("h") || input.equals("V") ||
                input.equals("v"));
    }

    public static void showMoveDirectionPrompt() {
        System.out.println("In which direction would you like to move the car?");
        System.out.println("  H: horizontal");
        System.out.println("  V: vertical");
    }

    public static void showHowFarPrompt(boolean horizontalMove) {
        if (horizontalMove) {
            System.out.print("How far (negative value to move left)? ");
        } else {
            System.out.print("How far (negative value to move up)? ");
        }
    }

    public static void doMove(int carIndex, boolean ignition, char color, 
                                int[] position, int[] move) {

        // Move the car if the move is not out of bounds.
        if (validMove(position, move)) {
            updatePosition(position, move);
            displayStatus(carIndex, ignition, color, position, true);

        } else {
            // Don't move the car.
            System.out.println("ERROR: That move is out of bounds!");
            printPosition(position);
            System.out.println();
        }

    }

    public static void updatePosition(int[] position, int[] move) {
        position[0] += move[0];
        position[1] += move[1];
    }

    public static boolean validMove(int[] position, int[] move) {
        // Reports wheter the move is still within the [1,1] to [20,20] grid.
        int newX = position[0] + move[0];
        int newY = position[1] + move[1];
        return (newX >= 1 && newX <= 20 && newY >= 1 && newY <= 20);
    }

    public static void displayStatus(int carIndex, boolean ignition, char color,
                                     int[] position, boolean printGrid) {
        // Display the car's attributes.
        System.out.println("Car #" + (carIndex + 1) + " Information");
        System.out.println("Color: " + fullColor(color));
        System.out.println("Ignition: " + ignitionState(ignition));
        printPosition(position);
        if (printGrid)
            printOverhead(color, position);
    }

    public static void printPosition(int[] position) {
        // Display the current (X,Y) position of the car.
        System.out.println("Location: (" + position[0] + "," + position[1] + ")");
    }

    public static String fullColor(char color) {
        String fullColor;

        // Determine the corresponding full color output String for char color.
        if (color == 'R')
            fullColor = "red";
        else if (color == 'G')
            fullColor = "green";
        else if (color == 'B')
            fullColor = "blue";
        else if (color == 'W')
            fullColor = "white";
        else if (color == 'S')
            fullColor = "silver";
        else
            fullColor = "ERROR!";

        return fullColor;
    }

    public static void printOverhead(char color, int[] position) {
        // Dispay a 2-dimensional overhead view from [1,1] to [20,20]
        for (int y = 1; y <= 20; y++) {
            for (int x = 1; x <= 20; x++) {
                if (position[0] == x && position[1] == y)
                    System.out.print(" " + color);
                else
                    System.out.print(" -");
            }
            System.out.println();
        }
    } // end printOverhead

} // end CarSimulator