/**
 * Author:   Sean Herman
 * Date:     10/06/2013
 * HW#:      #03
 * File:	   CarSimulator.java
 * Summary:  Simulates the movement and behavior of a car in a 2-dimensional
 *  plane. The car's attributes include its color, its position (x,y) , and its
 *  ignition state (on/off). Users may control the ignition, and move the car
 *  around witin its boundaries. After each move, the position of the car is
 *  displayed.
 *
 * Note:    I made some small changes to the program that (I think) improve its
 *  readability. The original assignment called for 2 separate methods for moving
 *  the car: one horizontal, one vertical. I feel that a single method works best
 *  with the car's (X,Y) position stored in an Array. Using this approach, it
 *  seemed best to also store the move as an Array (X,Y). This approach seems 
 *  preferable, since it consolidates the move functionality to a single method,
 *  which should reduce duplicated code and make for easier in.
 *
 */

import java.util.Scanner;

public class CarSimulator {
    public static void main(String[] args) {
        // Ignitions "starts" (true) and "stops" (false) the car.
        boolean ignition = false;

        // Seelect a random a color from 1 of 5 options.
        char carColor = assignColor();

        // Select a random position from [1,1] to [20,20]
        int[] startingPosition = new int[2];
        randomPosition(startingPosition);

        driveCar(ignition, carColor, startingPosition);
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

    public static void driveCar(boolean ignition, char color, int[] position) {
        Scanner input = new Scanner(System.in);
        String inputValue;
        boolean quitter;

        // Show the initial state of the car.
        System.out.println();
        displayStatus(ignition, color, position);
        System.out.println();

        do {
          // Prompt user for action
          showDoPrompt();
          
          // Get input from the user.
          inputValue = input.next();
          System.out.println();
          quitter = (inputValue.equals("Q") || inputValue.equals("q"));

          // Check the input value.
          if (inputValue.equals("1")) { // Switch ignition.
              ignition = switchIgnition(ignition);
              System.out.println();

          } else if (inputValue.equals("2")) { // Change position.

              if (ignition) {
                  changePosition(ignition, color, position, input);
              } else {
                  System.out.println("ERROR: You must turn on the ignition first!");
                  System.out.println();
              } 

          } else if (!quitter) { // unrecognized entry
              System.out.println("ERROR: Invalid selection.");
              System.out.println();

          }
        } while(!quitter); 
    } // end driveCar

    public static void showDoPrompt() {
        System.out.println("What would you like to do?");
        System.out.println("  1: Turn the ignition on/off.");
        System.out.println("  2: Change the position of car.");
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

    public static void changePosition(boolean ignition, char color, int[] position, 
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
          doMove(ignition, color, position, move);
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

    public static void doMove(boolean ignition, char color, int[] position, 
                              int[] move) {

        // Move the car if the move is not out of bounds.
        if (validMove(position, move)) {
            updatePosition(position, move);
            displayStatus(ignition, color, position);

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

    public static void displayStatus(boolean ignition, char color, 
                                    int[] position) {
        // Display the car's attributes.
        System.out.println("Car Information");
        System.out.println("Color: " + fullColor(color));
        System.out.println("Ignition: " + ignitionState(ignition));
        printPosition(position);
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