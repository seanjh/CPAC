package homework;

/**
 * Name:    Sean Herman
 * Date:    09/28/2013
 * Homework: #03
 * File:	CarSimulator.java
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
    }

    public static void driveCar(boolean ignition, char color, int[] position) {
        //
    }

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

    public static boolean switchIgnition(boolean ignition) {
        return !ignition;
    }

}



/*

You should write a method for each of the following:

random position:
Randomly picks a number between 1 and 20 to set as an X or Y coordinate.
This method should only be called once for X and once for Y at the beginning of the program.

color assignment:
Randomly picks one of the five colors and returns the corresponding char ('R', 'G', 'B', 'W', 'S') to main().
This method should be called once at the beginning of the program. The color will not change during the execution of the program.

move car horizontally:
This method will take as arguments the current ignition state, the current X coordinate, the number of spaces you
would like to move the car (a negative value will move the car left; positive value will move the car right).
It will return the new horizontal position of the car after it is moved.

If the car's ignition is not on, this method tells the user that he/she must turn the ignition on first and returns
the current X position (does not move the car).

If the user tries to move the car beyond the border of the 20x20 grid, this method outputs an error message and
returns the current X position (does not move the car).

move car vertically: This method will take as arguments the current ignition state, the current Y coordinate,
the number of spaces you would like to move the car (a negative value will move the car up; positive value will move
the car down). It will return the new vertical position of the car after it is moved.

If the car's ignition is not on, this method tells the user that he/she must turn the ignition on first and returns
the current Y position (does not move the car).

If the user tries to move the car beyond the border of the 20x20 grid, this method outputs an error message and
returns the current Y position (does not move the car).

change ignition state: This method will return the opposite of the ignition value which is given to it as a
parameter (e.g. it will turn the car off when it is on or on when it is off). The new ignition value is returned
for storage in main().

report the state of the car: After each action, you should print the "state" of the car. This method will take
all the car's characteristics as arguments and report the status of each, including a visual representation of
the car's position in the grid.

For example, the output might look something like this (indicating car location on the grid with 'R' because the car's color is red):
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