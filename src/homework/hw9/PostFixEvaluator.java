//
// PostFixEvaluator.java        by Dale/Joyce/Weems     Chapter 3
//
// Provides a postfix expression evaluation
//

import java.util.Scanner;

public class PostFixEvaluator {
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
