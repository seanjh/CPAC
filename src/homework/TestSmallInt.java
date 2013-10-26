import java.util.Scanner;

public class TestSmallInt {
	public static void main(String[] args) {

		// Initialize Scanner, and internal loop variables
		Scanner input = new Scanner(System.in);
		boolean quitter;
		int i;

		do {
			// Prompt the user for input
			System.out.print("Please enter a number from 0 to " +
								SmallInt.MAXVALUE + " (-1 to quit) >> ");
			i = input.nextInt();
			System.out.println();

			quitter = (i == -1);
			if (!quitter) {
				printSmallInt(new SmallInt(i));
			}

		} while (!quitter);
	}

	public static void printSmallInt(SmallInt s) {
		System.out.println("Decimal:\t" + s.getDec());
		System.out.println("Binary: \t" + s.getBin());
		System.out.println("Hexidecimal:\t" + s.getHex());
	}
 }