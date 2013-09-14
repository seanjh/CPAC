package ch2;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 9/14/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompoundValue {
    public static void main(String[] args) {
        // Prompt the user for the Annual Percentage Rate (APR).
        String input = JOptionPane.showInputDialog(
                "Enter the annual interest rate (e.g., 5.5):");
        double apr = Double.parseDouble(input);
        double monthlyRate = apr / 1200;

        input = JOptionPane.showInputDialog("" +
                "Enter the amount deposited each month (e.g., 100.25):");
        double deposit = Double.parseDouble(input);

        // Calculate compound interest (over 6 months)
        // First month
        double accountBalance = deposit * (1 + monthlyRate);
        // Second month
        accountBalance = (deposit + accountBalance) * (1 + monthlyRate);
        // Third month
        accountBalance = (deposit + accountBalance) * (1 + monthlyRate);
        // Forth month
        accountBalance = (deposit + accountBalance) * (1 + monthlyRate);
        // Fifth month
        accountBalance = (deposit + accountBalance) * (1 + monthlyRate);
        // Sixth month
        accountBalance = (deposit + accountBalance) * (1 + monthlyRate);

        // Display the new account balance
        JOptionPane.showMessageDialog(null, "After the sixth month" +
                " the account value is: $" + accountBalance);
    }
}
