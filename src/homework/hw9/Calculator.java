/*
* File:         Calculator.java
* Author:       Sean Herman
* Date:         12/03/2013
* Assignment:   #9
* Summary:      Converts an input infix expression String into its postfix 
    equivalent, and evaluates the result.

* Assumptions:  Updated PostFixEvaluator to add the ^, and to return a double. 
*   The original class returned an int, but this obviously produces bad results 
*   for expressions with division. The assignment does show the result as 
*   a decimal value (3.0), so I assume this was a requirement.
*
*   I also added a few helper classes to aid in tokenizing the input infix 
*   expression (InfixIterator), and process/validate operators (Operator) 
*   Finally, I also added an InfixException class in the spirit of the 
*   PostFixException class provided by the Dale book. Since this class is used 
*   by Calculator and Converter, I've included that code in a separate file. 
*   Ideally, all these helper classes would be in separate .java source
*   files, but I felt it was probably easier for grading to lump them with the
*   2 required files, Converter.java and Calculator.java.
*
*   Execution requires the following 8 files from the Dale book:
*       ArrayStack.java, StackInterface.java, BoundedStackInterface.java, 
*       StackUnderflowException.java, StackOverflowException.java, 
*       ArrayUnsortedList.java, ListInterface.java, and PostFixException.java
* 
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculator {    
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

    // PostFixEvaluator evaluates a postfix expression String.
    private static class PostFixEvaluator {
        public static double evaluate(String expression) throws PostFixException {
            BoundedStackInterface<Double> stack = new ArrayStack<Double>(50);

            int value;
            String operator;

            double operand1;
            double operand2;

            double result = 0;

            Scanner tokenizer = new Scanner(expression);

            while (tokenizer.hasNext()) {
                if (tokenizer.hasNextInt()) {
                    value = tokenizer.nextInt();
                    // Process the operand
                    
                    if (stack.isFull())
                        throw new PostFixException("Too many operands. Stack Overflow");
                    
                    stack.push((double)value);
                } else {
                    // Process the operator
                    operator = tokenizer.next();

                    // Obtain second operand from stack.
                    if (stack.isEmpty())
                        throw new PostFixException("Not enough operands - stack underflow");
                    
                    operand2 = stack.top();
                    stack.pop();
                    
                    // Obtain first operand from stack.
                    if (stack.isEmpty())
                        throw new PostFixException("Not enough operands - stack underflow");

                    operand1 = stack.top();
                    stack.pop();

                    // Perform operation
                    if (operator.equals("/") | operator.equals("÷"))
                        result = operand1 / operand2;
                    else if (operator.equals("*") | operator.equals("x"))
                        result = operand1 * operand2;
                    else if (operator.equals("+"))
                        result = operand1 + operand2;
                    else if (operator.equals("-"))
                        result = operand1 - operand2;
                    else if (operator.equals("^"))
                        result = (int)(Math.pow(operand1, operand2));
                    else
                        throw new PostFixException("Illegal symbol: " + operator);

                    // Push result to the stack
                    stack.push(result);
                }
            }

            // Obtain the final result from stack
            if (stack.isEmpty())
                throw new PostFixException("Not enough operands - stack underflow");
            
            result = stack.top();
            stack.pop();

            // Stack should now be empty.
            if (!stack.isEmpty())
                throw new PostFixException("Too many operands - operands left over");

            // Return the final result
            return result;
        }
    }
}