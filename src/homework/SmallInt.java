public class SmallInt {
    
    public static final int MAXVALUE = 1000;
    private int value;

    SmallInt(int value) {
        if (isInRange(value)) {
            this.value = value;
        } else {
            // Value is set to 0 when it is below 0 or above MAXVALUE
            printOutOfRange(value);
            this.value = 0;
        }
    }

    private boolean isInRange(int input) {
        return input <= MAXVALUE && input >= 0;
    }

    public void printOutOfRange(int input) {
        System.out.printf("ERROR: %d is outside the valid range (0-%d). " +
                        "Using default value 0.\n", input, MAXVALUE);
    }

    public String getDec() {
        // Converts value to a String using coercion
        return "" + value;
    }

    public void setDec(int value) {
        if (isInRange(value)) {
            this.value = value;
        } else {
            printOutOfRange(value);
        }
    }

    /* This loop "consumes" the decimal value, producing a binary string.
     * Each binary place, beginning with the first (2^0) is derived by
     * dividing by 2, since binary is a base 2 system. Really, 2 operations
     * are performed: integer division, and a modulus operation. The latter
     * operation, the remainder, represents the binary value at the lowest
     * binary position. The "remains" are what's left of the original value
     * after the integer division.
     *
     * Consider the number 301. This loop divides our starting value by 2 using
     * integer division. 
     *
     *  Iteration #1: 301 / 2
     *      result = 150 (the remains)
            remainder = 1 (the binary value at the lowest available position)
            binary (so far) = "1"
     * 
     * The loop begins again, because 6 > 0 (i.e., we have not "consumed"
     * or converted the whole original value).
     *
     *  Iteration #3: 150 / 2
     *      result = 75
     *      remainder = 0
     *      binary = "01"
     *  Iteration #4: 75 / 2
     *      result = 37
     *      remainder = 1
     *      binary = "101"
     *  ... 37/2 "1", 18/2 "0", 9/2 "1", 4/2 "0", 2/2 "0" ...
     *  Iteration #9: 1 / 2
     *      result = 0
     *      remainder = 1
     *      binary = "100101101"
     *
     * Iteration now terminates, since the result was 0, signifying that the 
     * whole value was converted. Our resulting binary string is "100101101".
     * In effect, these repeated divisions by 2 are equivalent to dividing the
     * original value by increasing powers of 2. That is, the first operation is 
     * the original / 2. The next is the remains / 2, or (original / 2) / 2, 
     * which is equivalent to original / 4 (2^2). This continues until the result
     * is 0.
    */
    public String getBin() {
        // Remains represents the amount of the decimal left to convert
        int remains = value;
        String binaryEquiv = "";
        int binValue;

        do {
            binValue = remains % 2;

            // Append to the front of the existing string
            binaryEquiv = binValue + binaryEquiv;
            
            // Each iteration, work up 1 binary place
            // This effectively "increases" the power of 2 up from 1 (2^0)
            remains /= 2;
        } while (remains > 0);

        return binaryEquiv;
    }

    /*
    * The logic and loop for getHex is identical to the getBin() logic, except
    * at each iteration we divide by 16. The only addition is that we need to
    * substitute any decimal remainder > 9 with its appropriate (a-f) hexidecimal
    * equivalent. For example, consider the decimal value 75.
    *
    * Iteration #1: 75 / 16
    *       result = 4 (the remains)
    *       remainder = 11
    *       hex = "b" (substituting for 11)
    * Iteration #2: 4 / 16
    *       result = 0
    *       remainder = 4
    *       hex = "4b"
    *
    * The loop terminates, since the result was 0. This logic produces "4b" as
    * the hexidecimal equivalent of 75.
    *
    */
    public String getHex() {
        int remains = value;
        String hexEquiv = "";
        int hexValue;

        do {
            hexValue = remains % 16;
            hexEquiv = getHexDigit(hexValue) + hexEquiv;

            remains /= 16;
        } while (remains > 0);

        return hexEquiv;
    }
    
    // Returns a String representing the hex equivalent of a base-10 value from 0-15
    private String getHexDigit(int i) {
        // When i > 9, return the the letter equivalent of the decimal value. 
        // Otherwise, return the original decimal value as a String.
        switch (i) {
            case(10):   return "a";
            case(11):   return "b";
            case(12):   return "c";
            case(13):   return "d";
            case(14):   return "e";
            case(15):   return "f";
            default:    return "" + i;
        }
    }

    // Randy/Alex: May be ignored. Just added as a curiosity. This method is not
    // utilized anywhere within the TestSmallInt class or the SmallInt class.
    public String getOct() {
        int remains = value;
        String octEquiv = "";
        int octValue;

        do {
            octValue = remains % 8;
            octEquiv = octValue + octEquiv;

            remains /= 8;
        } while (remains > 0);

        return octEquiv;
    }
}