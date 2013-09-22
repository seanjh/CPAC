import java.util.Scanner;

public class GreatestCommonDivisor {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to input 2 integers
		System.out.print("Enter the first integer: ");
		int n1 = input.nextInt();
		System.out.print("enter the second integer: ");
		int n2 = input.nextInt();

		int gcd = 1;
		if (n1 == n2)
			gcd = n1;
		else {
			for (int k = 2; k <= n1 / 2 && k <= n2 / 2; k++) {
			//for (int k = 2; k <= n1 && k <= n2; k++) {
				if (n1 % k == 0 && n2 % k == 0)
					gcd = k;
			}
		}
		
		System.out.println("The greatest common divisor of " +
			n1 + " and " + n2 + " is " + gcd);
	}
}
