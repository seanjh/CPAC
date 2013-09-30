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
		int powerOfTwo = 1; 
		long binaryPlace = 1;

		// Find minimum power of 2 needed for this input.
		while (inputInt >= powerOfTwo * 2) {
			powerOfTwo *= 2;
			binaryPlace *= 10;
		}

		int remainder = inputInt;
		long binaryValue = 0;
		// Cycle down powers of 2
			// BEFORE i-6 pot-4 dp-100 dv-0
			// pot-2 dp-10 dv-100
			// pot-1 dp-1 dv-110
			// pot-0 dp-0 dv-110
		while (powerOfTwo >= 1) {
			// Remainder value holds this power of 2
			if (remainder / powerOfTwo > 0) {
				binaryValue += binaryPlace;
				remainder -= powerOfTwo;
			}
			binaryPlace /= 10;
			powerOfTwo /= 2;
		}

		// Display the result
		System.out.println(inputInt + " in binary: " + binaryValue);
	}

}
