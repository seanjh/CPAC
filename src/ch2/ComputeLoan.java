package ch2;

//import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 9/14/13
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */

// Convert rate to decimal
// Compute the monthly payment
// compute the total payment
// display result

public class ComputeLoan {
    public static void main(String[] args) {

        // Create a new Scanner object
        // Scanner input = new Scanner(System.in);

        // Prompt user to input the annual interest rate.
        //System.out.print("Enter annual interest rate (e.g., 7.25%): ");
        //double annualInterestRate = input.nextDouble();
        String inputString = JOptionPane.showInputDialog(
                "Enter annual interest rate (e.g., 7.25%):");
        double annualInterestRate = Double.parseDouble(inputString);

        // Derive monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;

        // Prompt for the number of years.
        //System.out.print("Enter number of years as an integer (e.g., 5): ");
        //int numberOfYears = input.nextInt();
        inputString = JOptionPane.showInputDialog(
                "Enter number of years as an integer (e.g., 5):");
        int numberOfYears = Integer.parseInt(inputString);

        // Prompt for loan amount.
        //System.out.print("Enter loan amount (e.g., 120000.55): ");
        //double loanAmount = input.nextDouble();
        inputString = JOptionPane.showInputDialog(
                "Enter loan amount (e.g., 120000.55):");
        double loanAmount = Double.parseDouble(inputString);

        // Calculate payment
        double monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
        double totalPayment = monthlyPayment * numberOfYears * 12;

        // Display results
        //System.out.println("The total monthly payment is $" +
        JOptionPane.showMessageDialog(null, "The total monthly payment is $" +
            (int)(monthlyPayment * 100) / 100.0);
        //System.out.println("The total payment is $" +
        JOptionPane.showMessageDialog(null, "The total payment is $" +
            (int)(totalPayment * 100) / 100.0);
    }
}
