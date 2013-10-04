

public class TestPrint {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello, world");
		
		System.out.println();
		System.out.println();

		System.out.println("Testing carriage return: ");
		String[] myStrings = {"Zero ", "One  ", "Two  ", "Three", "Four ", "Five "};
		for (int i = 0; i < myStrings.length; i++) {
			System.out.print("\r" + myStrings[i]);
			 Thread.sleep(100);
		}

		System.out.println();
		System.out.println();

		System.out.println("Testing carriage return: ");

		int[] testArray = new int[100];

		for (int i =0; i < testArray.length; i++) {
			testArray[i] = (int) (Math.random() * 20 + 1);
		}

		for (int i = 0; i < testArray.length; i++) {
			System.out.printf("\r\r%2d\n%2d", testArray[i], testArray[i] * 2);
			Thread.sleep(10);
		}

		System.out.println();
		System.out.println();

		System.out.println("Done!");
	}
}


/*

You should write a method for each of the following:

random position: Randomly picks a number between 1 and 20 to set as an X or Y coordinate. This method should only be called once for X and once for Y at the beginning of the program.

color assignment: Randomly picks one of the five colors and returns the corresponding char ('R', 'G', 'B', 'W', 'S') to main(). This method should be called once at the beginning of the program. The color will not change during the execution of the program.

move car horizontally: This method will take as arguments the current ignition state, the current X coordinate, the number of spaces you would like to move the car (a negative value will move the car left; positive value will move the car right). It will return the new horizontal position of the car after it is moved. 

If the car's ignition is not on, this method tells the user that he/she must turn the ignition on first and returns the current X position (does not move the car). 

If the user tries to move the car beyond the border of the 20x20 grid, this method outputs an error message and returns the current X position (does not move the car).

move car vertically: This method will take as arguments the current ignition state, the current Y coordinate, the number of spaces you would like to move the car (a negative value will move the car up; positive value will move the car down). It will return the new vertical position of the car after it is moved. 

If the car's ignition is not on, this method tells the user that he/she must turn the ignition on first and returns the current Y position (does not move the car). 

If the user tries to move the car beyond the border of the 20x20 grid, this method outputs an error message and returns the current Y position (does not move the car).

change ignition state: This method will return the opposite of the ignition value which is given to it as a parameter (e.g. it will turn the car off when it is on or on when it is off). The new ignition value is returned for storage in main().

report the state of the car: After each action, you should print the "state" of the car. This method will take all the car's characteristics as arguments and report the status of each, including a visual representation of the car's position in the grid. 

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