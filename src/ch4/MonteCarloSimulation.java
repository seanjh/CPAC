import java.util.Scanner;

public class MonteCarloSimulation {
	/** Main method */
	public static void main(String[] args) {
		//final int NUMBER_OF_TRIALS = 1000000;
		int numberOfHits = 0;

		// Create a new Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt for a number of simulations
		System.out.print("Input the number of simulations: ");
		int numberOfTrials = input.nextInt();

		for (int i = 0; i < numberOfTrials; i++) {
			double x = Math.random() * 2.0 - 1;
			double y = Math.random() * 2.0 - 1;
			if (x * x + y * y <= 1)
				numberOfHits++;
		}

		double pi = 4.0 * numberOfHits / numberOfTrials;
		System.out.println("After " + numberOfTrials + 
			" trials, Pi is estimated as " + pi);
	}
}
