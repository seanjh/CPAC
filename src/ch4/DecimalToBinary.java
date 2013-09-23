import java.util.Scanner;

public class DecimalToBinary {
	public static void main(String[] args) {
		// Introduce the program
		System.out.println("This program computes the binary equivalent of an input integer value.");

		// Create a new Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user for an input integer
		System.out.print("Integer: ");
		int inputInt = input.nextInt();

		// Initialize values
		int powerOfTwo = 1, binaryPlace = 1, binaryValue = 0;

		// Find minimum/first power of 2 greater than the input value
		while (inputInt > powerOfTwo) {
			if (power > 0 && (inputInt % powerOfTwo) != 0)
				binaryValue += binaryPlace;
			binaryPlace *= 10;
			powerOfTwo *= 2;
		}
		if ((inputInt % 2) != 0)
			binaryValue += 1; // Odd number

		System.out.println(inputInt + "'s binary value is " + binaryValue);
	
	// sumProducts = 1, power = 0, binaryPlace = 1, binaryValue = 0
		// while (value > sumProduct)
			// if (power == 0 && value % 2 != 0)
				//  binaryPlace	+= 1;
			// else if value % sumProducts != 0 	
				// binaryValue += (1 * binaryPlace) 
			// binaryPlace *= 10; 
			// sumProducts *=2;
			// power++;
	// Cycle through modulo for each power of 2
		// first, get the value of 2 ^ i
		// if value % (power of 2) == 0, then print 1 else print 0
	}

}
