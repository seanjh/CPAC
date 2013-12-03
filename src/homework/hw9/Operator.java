public class Operator implements Comparable<Operator> {
    private static final String[] OPERATORS = {
        "+", "-", "*", "x", "/", "÷", "^"
    };
    
    private static final String[][] RANKINGS = {
        // 2-dimensional array (i.e., X,Y). The 1st dimension (X) index value
        // corresponds to the operator's rank.
        {"-", "+"}, // rank 0 (lowest)
        {"*", "/", "x", "÷"}, // rank 1
        {"^"} // rank 2 (highest)
    };

    private String operator;
    private int rank;

    public static boolean isOperator(String input) {
        for (int i = 0; i < OPERATORS.length; i++) {
            if (input.equals(OPERATORS[i]))
                return true;
        }
        return false;
    }

    public static boolean isOperator(char input) {
        Character c = (Character) input;
        return Operator.isOperator(c.toString());
    }

    public Operator(String operator) throws IllegalArgumentException {
        if (Operator.isOperator(operator))
            this.operator = operator;
        else 
            throw new IllegalArgumentException("Invalid operator input");

        // Determine the rank of the operator
        for (int i = 0; i < RANKINGS.length; i++)
            for (int j = 0; j < RANKINGS[i].length; j++)
                if (operator.equals(RANKINGS[i][j])) {
                    rank = i;
                    return;
                }
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