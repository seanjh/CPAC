/*
* File:         Converter.java
* Author:       Sean Herman
* Date:         12/03/2013
* Assignment:   #9
* Summary:      Converts infix-style expressions into postfox-style expressions.
*       Input is a String representing a valid infix-style expression.
        Output is a String representing the corresponding postfix-style 
        expression.
*/

import java.util.NoSuchElementException;
import java.util.Iterator;

public class Converter {
    private String infix;       // input infix expression
    private String postfix;     // derived postfix equivalent expression
    BoundedStackInterface<String> stack;

    public Converter(String infix) {
        this.infix = infix;
        postfix = "";
        stack = new ArrayStack<String>(infix.length());
    }

    public String getInfix() {
        return infix;
    }

    public String toPostFix() throws InfixException {
        InfixIterator tokenizer = new InfixIterator(infix);
        String token;

        while(tokenizer.hasNext()) { // Keep looping while input token Strings remain
            token = tokenizer.next();

            if (Character.isDigit(token.charAt(0))) { // Operands always start with a digit
                postfix += token + " "; // always append operands to postfix
            } else if (token.equals("(")) { 
                stack.push("("); // always push open parens
            } else if (token.equals(")")) { 
                processCloseParens();
            } else {
                processOperator(new Operator(token));
            }
        }

        while (!stack.isEmpty()) { // clear out any remaining operators
            postfix += stack.top() + " "; // append these leftovers postfix
            stack.pop();
        }

        return postfix;
    }

    private void processCloseParens() {
        while (!stack.isEmpty()) {
            if (stack.top().equals("(")) {
                stack.pop(); // pop out the matching open parens
                break; // and stop looping through the stack
            } else { 
                postfix += (stack.top() + " "); // append top operator to postfix
                stack.pop();
            }
        }
    }

    private void processOperator(Operator tokenOp) {
        if (stack.isEmpty() || stack.top().equals("(")) {
            stack.push(tokenOp.getOperator());
            return; // always push operators on empty stack or for parens at top
        } else { // there's an operator at the top of the stack
            Operator stackOp = new Operator(stack.top());
            if (stackOp.compareTo(tokenOp) >= 0) { // i.e., if (this op >= stack op)
                postfix += stack.top() + " "; // append stack top's lower/equal rank operator
                stack.pop();
                processOperator(tokenOp);  // then do a recursive call
            } else {
                stack.push(tokenOp.getOperator()); // push this lower rank operator to stack
            }
        }
    }

    @Override
    public String toString() {
        return postfix;
    }
}

class Operator implements Comparable<Operator> {
    private String operator;
    private int rank;

    private static final String[] OPERATORS = {
        "+", "-", "*", "x", "/", "÷", "^"
    };
    
    private static final String[][] OPERATOR_RANKS = {
        // 2-dimensional array (i.e., X,Y). The 1st dimension (X) index value
        // corresponds to the operator's rank.
        {"-", "+"}, // rank 0 (lowest)
        {"*", "/", "x", "÷"}, // rank 1
        {"^"} // rank 2 (highest)
    };

    public Operator(String operator) throws IllegalArgumentException {
        if (isOperator(operator))
            this.operator = operator;
        else 
            throw new IllegalArgumentException("Invalid operator input");

        // Determine the rank of the operator
        for (int i = 0; i < OPERATOR_RANKS.length; i++)
            for (int j = 0; j < OPERATOR_RANKS[i].length; j++)
                if (operator.equals(OPERATOR_RANKS[i][j])) {
                    rank = i;
                    return;
                }
    }

    public static boolean isOperator(String input) {
        for (int i = 0; i < OPERATORS.length; i++) {
            if (input.equals(OPERATORS[i]))
                return true;
        }
        return false;
    }

    public static boolean isOperator(char input) {
        Character c = (Character) input;
        return isOperator(c.toString());
    }

    public int getRank() {
        return rank;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public int compareTo(Operator op) {
        // Compares this operator's rank to the parameter's rank
        if (rank < op.rank)
            return -1; // this operator's rank is less than (lower precedence)
        else if (op.rank == rank)
            return 0; // ranks are equal
        else
            return 1; // this operator's rank is greater than (higer precedence)
    }
}

class InfixIterator implements Iterator<String> {
    private String infix;
    private ListInterface<String> tokens;
    private String intBuffer;
    private int currentElement;

    public InfixIterator(String infix) throws InfixException {
        this.infix = infix;
        tokens = new ArrayUnsortedList(infix.length());
        currentElement = 0;

        // Translate the string into a list of Character objects
        Character[] charArray = new Character[infix.length()];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = new Character(infix.charAt(i));
        }

        intBuffer = ""; // accumulates adjacent digits in the String
        for (Character ch : charArray) {
            if (Character.isDigit(ch)) { 
                intBuffer += ch.toString(); // append digits to the int buffer
            } else if (Operator.isOperator(ch)) {
                addBuffer(); // add int buffer (if applicable)
                tokens.add(ch.toString()); // add operators to the list
            } else if (ch.equals('(') || ch.equals(')')) {
                addBuffer(); // add int buffer (if applicable)
                tokens.add(ch.toString()); // add parens to the list
            } else if (Character.isWhitespace(ch)) {
                addBuffer(); // add int buffer (if applicable)
                // Do not add spaces
            } else {
                throw new InfixException("Invalid character in infix " +
                "expression: " + ch);
            }
        }

        addBuffer(); // clear out any remaining buffer
    }

    public String getInfix() {
        return infix;
    }

    private void addBuffer() {
        if (!intBuffer.equals("")) {
            tokens.add(intBuffer); // add the accumulated int buffer to the list
            intBuffer = ""; // reset the String buffer
        }
    }

    @Override
    public boolean hasNext() {
        return currentElement < tokens.size();
    }

    @Override
    public String next() throws NoSuchElementException {
        currentElement++;
        return tokens.getNext();
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        String out = "";
        out += ("Inflix expression: " + infix + "\n");
        out += tokens.toString();
        return out;
    }
}