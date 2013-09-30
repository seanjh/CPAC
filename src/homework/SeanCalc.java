/**
 * Name:    Sean Herman
 * Date:    09/28/2013
 * HW:  	#02
 * File:	SeanCalc.java
 * Summary: This program is a simple calculator, capable of performing basic
 * 			arithmetic operations. The calculator supports addition (+),
 *			subtraction (-), multiplication (*), and division (/).
 *			
 *			There are 2 additional special operators: x and c
 * 				> The clear (c) operator resets the buffer value
 *				> The exit (x) operator will exit the calculator.
 */

import java.util.Scanner;

public class SeanCalc {
	public static void main(String[] args) {
		// Introduce the program
		System.out.println("Welcome to SeanCalc!");
		System.out.println();
		
		// Start the calcuator
		runCalculator();

		System.out.println();
		System.out.println("Thank you for using SeanCalc! Goodbye.");
	}

	public static void runCalculator() {
		// Create the Scanner instance
		Scanner input = new Scanner(System.in);

		// IDo a unique run for the 1st time through the calculator.
		double runningTotal = getInitialInputs(input);

		// Initialize the input and loop control values.
		String inputOperator;
		String inputValue;
		double inputDouble;
		boolean keepOn;

		do {
			// Get a new Operator
			inputOperator = getInput(input, "op");
			keepOn = keepOnKeepinOn(inputOperator); //  Ooh ooh ooh ooh

			if (inputOperator.equals("c") || inputOperator.equals("C")) {
				runningTotal = clearTotal();
			} else if (keepOn) {
				// Get another input value from the user
				inputValue = getInput(input, "more input");

				// Convert this input to a double
				inputDouble = Double.parseDouble(inputValue);

				// Update the running total
				runningTotal = updateRunningTotal(runningTotal, inputDouble,
					inputOperator);
			}
		} while(keepOn);

	}

	public static double getInitialInputs(Scanner input) {
		// Initialize input values
		String inputValue;
		String inputOperator;
		double secondDouble;
		double total;

		// Get the first input
		inputValue = getInput(input, "1st input");

		// Parse the first input string as a double
		total = Double.parseDouble(inputValue);

		// Get the first operator
		inputOperator = getInput(input, "op");

		// Get the second input, and convert it to a double
		inputValue = getInput(input, "2nd input");
		secondDouble = Double.parseDouble(inputValue);

		// Calculate the resulting total
		total = updateRunningTotal(total, secondDouble, inputOperator);

		return total;
	}

	public static boolean keepOnKeepinOn(String operator) {
		boolean keepOn = true;

		if (operator.equals("x") || operator.equals("X")) {
			keepOn = false;
		}
		
		return keepOn;
	}

    public static String getInput(Scanner input, String userPrompt) {
        // Prompt the user for some input
        System.out.print(userPrompt + ": ");

        // Pull in that input as a string
        String operator = input.next();

        return operator;
    }

    public static double updateRunningTotal(double oldTotal, double newValue, 
    										String operator) {
    	double total = oldTotal;
    	boolean showResult = true;

    	// Apply the approppriate arithmetic operation.
        if (operator.equals("+")) {
            total += newValue;
        } else if (operator.equals("-")) {
            total -= newValue;
        } else if (operator.equals("*")) {
            total *= newValue;
        } else if (operator.equals("/")) {
            if (newValue == 0.0) {
                System.out.println("Error: division by zero.");
                showResult = false;
            } else {
                total /= newValue;
            }
        // Show an error message if the operator is not recognized
        } else {
            System.out.println("Error: Unknown operator " + operator);
            showResult = false;
        }

        // When the total has changed, display that new result.
        if (showResult) {
        	System.out.print("ans: " + total);
			System.out.println();
        }

        return total;
    }

    public static double clearTotal() {
    	// Reset the runningTotal to 0.
    	double newTotal = 0.0;

    	// Display this reset total.
        System.out.print("ans: " + newTotal);
        System.out.println();

        return newTotal;
    }

}