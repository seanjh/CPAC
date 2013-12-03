import java.util.NoSuchElementException;
import java.util.Iterator;

public class InfixIterator implements Iterator<String> {
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
            tokens.add(intBuffer);
            intBuffer = "";
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