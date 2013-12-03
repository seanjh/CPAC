/*
* File:     Calculator.java
* Author:   Sean Herman
* Date:     12/2/2013
* 
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculator {
    public static final boolean DEBUG = false;
    
    public static void main(String[] args) {

        System.out.println("\nWelcome to Infix Calculator.\n");
        System.out.println("\tThis program evaluates infix-style arithmetic expressions. For");
        System.out.println("\teach valid input expression, this program evaluates the result, ");
        System.out.println("\tand displays the equivalent post-fix style expression.");
        System.out.println("\n\tExpressions should contain only integers, " +
            "operators, and parentheses.");
        System.out.println("\tSupported operators: * / + - ^\n\n");
        
        // display result with 1 decimal of precision
        DecimalFormat dec = new DecimalFormat("#.#");

        Command cmd = getCommand();

        while(!cmd.isQuit()) {
            try {
                Converter converter = new Converter(cmd.getInput());
                double result = PostFixEvaluator.evaluate(converter.toPostFix());
                System.out.println("Postfix equivalent:\t" + converter);
                System.out.println("Answer:\t\t\t" + dec.format(result) + "\n");
            } catch (InfixException e) { // e.g., invalid characters in input
                System.out.println("Error processing input - " + e.getMessage());
            } catch (PostFixException e) { // e.g., unbalanced postfix expression
                System.out.println("Error processing expression - " + e.getMessage());
            } catch (ArithmeticException e) { // e.g., divide by 0 error
                System.out.println("Error performing calculation - " + e.getMessage());
            } finally {
                //System.out.println();
                cmd = getCommand();
            }
        }
    }

    private static Command getCommand() {
        Scanner input = new Scanner(System.in);
        Command cmd = new Command();

        System.out.println("Please enter an infix expression (Q to quit) >> ");
        cmd.setExpression(input.nextLine());

        return cmd;
    }

    public static class Command {
        private String input;

        public void setExpression(String input) {
            this.input = input;
        }

        public String getInput() {
            return input;
        }

        public boolean isQuit() {
            return input.toLowerCase().equals("q");
        }
    }
}