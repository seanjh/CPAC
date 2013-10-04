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
 */

import java.util.Scanner;
//package homework;

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

      do {
        // Prompt user for action
        showDoPrompt();
        
        // Get input from the user
        inputValue = input.next();
        System.out.println();
        quitter = (inputValue.equals("Q") || inputValue.equals("q"));

        // Check the input
        if (inputValue.equals("1")) {
          ignition = switchIgnition(ignition);
          System.out.println();
        } else if (inputValue.equals("2")) {
          moveCar(ignition, color, position, input);
        } else if (!quitter) { // unrecognized entry
          System.out.println("Invalid input.");
          System.out.println();
        }
      } while(!quitter);
    } // end driveCar

    public static void showDoPrompt() {
      System.out.println("What would you like to do?");
      System.out.println("  1: turn the ignition on/off");
      System.out.println("  2: change the position of car");
      System.out.println("  Q: quit this program");
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

    public static void moveCar(boolean ignition, char color, int[] position, 
                              Scanner input) {
      int moveValue;
      boolean horizontalMove;
      String inputValue;
      int[] move = new int[2];

      if (ignition) { // car is on
          // Prompt the user to specify the direction
          showMoveDirectionPrompt();
          inputValue = input.next();
          System.out.println();

          // Save that direction
          horizontalMove = inputValue.equals("H") || inputValue.equals("h");
          // #TODO validate input. 
          // Currently accepts ANYTHING that's not H or h as a V move

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

          // Get movin'
          doMove(ignition, color, position, move);
      } else { // ignition is off
          System.out.println("Turn on the ignition first.");
          System.out.println();
      }

    } // end moveCar

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
        if (validMove(position, move)) {
            updatePosition(position, move);
            displayStatus(ignition, color, position);
        } else {
            System.out.println("ERROR: That move is out of bounds.");
            printPosition(position);
            System.out.println();
        }

    }

    public static void updatePosition(int[] position, int[] move) {
        position[0] += move[0];
        position[1] += move[1];
    }

    public static boolean validMove(int[] position, int[] move) {
        int newX = position[0] + move[0];
        int newY = position[1] + move[1];
        return (newX >= 0 && newX <= 20 && newY >= 0 && newY <= 20);
    }

    public static void displayStatus(boolean ignition, char color, 
                                    int[] position) {
        System.out.println("Car Information");
        System.out.println("Color: " + fullColor(color));
        System.out.println("Ignition: " + ignitionState(ignition));
        printPosition(position);
        printOverhead(color, position);
    }

    public static void printPosition(int[] position) {
        System.out.println("Location: (" + position[0] + "," + position[1] + ")");
    }

    public static String fullColor(char color) {
        String fullColor;
        
        // Determine the corresponding full color name for char color
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
          fullColor = "ERROR";

        return fullColor;
    }

    public static void printOverhead(char color, int[] position) {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                if (position[0] == x && position[1] == y)
                    System.out.print(" " + color);
                else
                    System.out.print(" -");
            }
            System.out.println();
        }
    }
} // end of CarSimulator