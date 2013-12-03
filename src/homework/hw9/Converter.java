//
// Converter.java
// 
// Converts infix-style expressions into postfox-style expressions.
// 
//  Input:  String representing a valid infix-style expression
//  Output: String representing the corresponding postfix-style expression

public class Converter {
    
    private String infix;
    private String postfix;
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

        if (Calculator.DEBUG)
            System.out.println(tokenizer);

        while(tokenizer.hasNext()) {
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

            if (Calculator.DEBUG){
                printStatus(token);
                System.out.println();
            }
        }

        while (!stack.isEmpty()) {
            if (Calculator.DEBUG){
                System.out.println("Clearing stack.");
                printStatus(new String(""));
            }
            postfix += stack.top() + " "; // append operators left in stack
            stack.pop();
        }

        if (Calculator.DEBUG)
                printStatus(new String(""));

        return postfix;
    }

    private void printStatus(String token) {
        System.out.print("Token: " + token + ", ");
        System.out.print("Stack: " + stack + ", ");
        System.out.println("Postfix: " + postfix);
    }

    private void processCloseParens() {
        while (!stack.isEmpty()) {
            if (stack.top().equals("(")) { 
                stack.pop();
                break; // Pop out the matching parens and break
            } else {
                postfix += (stack.top() + " ");
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
            if (stackOp.compareTo(tokenOp) >= 0) {
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