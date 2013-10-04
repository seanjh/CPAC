package homework;

import java.util.Scanner;

/**
 * Name:    Sean Herman
 * Date:    09/28/2013
 * Homework: #03
 * File:	 CarSimulator.java
 * Summary: 
 */

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
        quitter = (inputValue.equals("Q") || inputValue.equals("q"));

        // Check the input
        if (inputValue.equals("1")) {
          ignition = switchIgnition(ignition);
        } else if (inputValue.equals("2")) {
          moveCar(ignition, color, position, input);
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

    public static void moveCar(boolean ignition, char color, int[] position, Scanner input) {
      int moveValue;
      boolean horizontalMove;
      String inputValue;
      int[] move = new int[2];

      if (ignition) { // car is on
          // Prompt the user to specify the direction
          showMoveDirectionPrompt();
          inputValue = input.next();

          // Save that direction
          horizontalMove = inputValue.equals("H") || inputValue.equals("h");

          // Prompt the user to specify how far
          showHowFarPrompt(horizontalMove);
          inputValue = input.next();
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
      } else {
          System.out.println("Turn on the ignition first.");
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

    public static void doMove(boolean ignition, char color, int[] position, int[] move) {
        if (validMove(position, move)) {
            updatePosition(position, move);
            displayStatus(ignition, color, position);
        } else {
            System.out.println("ERROR: That move is out of bounds.");
            printPosition(position);
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

    public static void displayStatus(boolean ignition, char color, int[] position) {
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
        String fullColor = "Hello, World."; // #TODO fix this method
        String[] colorStrings = {"red", "green", "blue", "white", "silver"};

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
}



/*
After this beginning state is assigned to the car, you should then have a loop 
which asks the user what he/she wants to do next. For example:

  What would you like to do?
  1: turn the ignition on/off
  2: change the position of car
  Q: quit this program
If the user selects '1' to turn the car's ignition on or off, then your program 
will call the method that changes the ignition state (explained below), and 
save the new ignition value in place of the old one.

If the user selects '2' to change the car's position, you will prompt the user 
for a direction. For example:

  In which direction would you like to move the car?
  H: horizontal
  V: vertical
And then prompt for the distance. For example:

  How far (negative value to move left)?    or    How far (negative value to 
  move up)?
Then your program will call the appropriate method (move horizontal or move 
vertical -- see below) with suitable arguments.



You should write a method for each of the following:

random position:
Randomly picks a number between 1 and 20 to set as an X or Y coordinate.
This method should only be called once for X and once for Y at the beginning 
of the program.

color assignment:
Randomly picks one of the five colors and returns the corresponding char 
('R', 'G', 'B', 'W', 'S') to main().
This method should be called once at the beginning of the program. The color 
will not change during the execution of the program.

move car horizontally:
This method will take as arguments the current ignition state, the current 
X coordinate, the number of spaces you would like to move the car (a negative 
value will move the car left; positive value will move the car right). It will 
return the new horizontal position of the car after it is moved.

If the car's ignition is not on, this method tells the user that he/she must 
turn the ignition on first and returns the current X position 
(does not move the car).

If the user tries to move the car beyond the border of the 20x20 grid, 
this method outputs an error message and returns the current X position (does 
not move the car).

move car vertically: This method will take as arguments the current ignition 
state, the current Y coordinate, the number of spaces you would like to move 
the car (a negative value will move the car up; positive value will move the 
car down). It will return the new vertical position of the car after it is moved.

If the car's ignition is not on, this method tells the user that he/she must 
turn the ignition on first and returns the current Y position (does not move 
the car).

If the user tries to move the car beyond the border of the 20x20 grid, this 
method outputs an error message and returns the current Y position (does not 
move the car).

change ignition state: This method will return the opposite of the ignition 
value which is given to it as a parameter (e.g. it will turn the car off when 
it is on or on when it is off). The new ignition value is returned for storage 
in main().

report the state of the car: After each action, you should print the "state" 
of the car. This method will take all the car's characteristics as arguments 
and report the status of each, including a visual representation of
the car's position in the grid.

For example, the output might look something like this (indicating car location 
on the grid with 'R' because the car's color is red):
  Car Information
  Color: red
  Ignition: on
  Location: (5, 17)
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - R - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
  - - - - - - - - - - - - - - - - - - - -
*/