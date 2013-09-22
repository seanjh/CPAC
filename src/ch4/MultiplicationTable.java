public class MultiplicationTable {
	/** Main method */
	public static void main(String[] args) {
		// Display table heading
		System.out.println("	  Multiplication Table");

		// Display the number table
		System.out.print("    ");
		for (int j = 1; j <= 9; j++)
			System.out.printf("   " + j);

		System.out.println("\n-----------------------------------------");

		// Display table body
		for (int i = 1; i <= 9; i++) {
			System.out.print(i + " | ");
			//Display the product and align properly
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%4d", i * j);
			}
		System.out.println();
		}
	}
}
