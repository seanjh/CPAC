import java.util.Scanner;
import java.lang.Math;

public class AmortizationTable {
	/** Main method */
	public static void main(String[] args) {
		// Introduce the program
		System.out.println("This program displays a Loan Amortization schedule.");
		
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Get input values from the user
		System.out.print("Loan Principal: ");
		int loanAmount = input.nextInt();
		System.out.print("Loan Term (in years): ");
		int loanYears = input.nextInt();
		System.out.print("APR (e.g. 5): ");
		int loanRateInput = input.nextInt();
		double loanRate = (double)(loanRateInput / 100.0); // Rate converted to decimal
		int totalTerms = loanYears * 12;
	
		// Calculate total payments and monthly payments
		double monthlyRate = loanRate / 12;
		//double monthlyPayment = 1.0;
		double denominator = 1.0;
		for (int i = 0; i < totalTerms; i++) {
			denominator *= 1.0 / (1.0 + monthlyRate);
		}
		double monthlyPayment = loanAmount * ( monthlyRate / (1.0 - denominator));
		double totalPayment = monthlyPayment * totalTerms;
	
		// Display total amount and monthly payments
		System.out.printf("Monthly payment: $%.2f %n", monthlyPayment);
		System.out.printf("Total payment: $%.2f %n", totalPayment);
	
		// Print header row
		double interestPayment, principalPayment, balance = loanAmount;
		System.out.println("Payment#     Interest      Principal   Balance");
		for (int i = 0; i < totalTerms; i++) {
			interestPayment = monthlyRate * balance;
			if (balance > monthlyPayment) {
				principalPayment = monthlyPayment - interestPayment;
				balance -= monthlyPayment;
			}
			else {
				principalPayment = balance - interestPayment;
				balance -= (principalPayment + interestPayment);
			}
		
			System.out.printf("%-11d %-11.2f %-11.2f %-11.2f%n", (i + 1), interestPayment, principalPayment, balance);
		}
	}
}
