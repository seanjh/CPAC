package ch3;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/15/13 5:49 PM
 */
public class Quadratic {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "This program will calculate " +
                "the 2 roots of a quadratic equation.\n" +
                "(i.e, a(x^2) + bx + c = 0)","Quadratic",JOptionPane.INFORMATION_MESSAGE);
        int a = Integer.parseInt(JOptionPane.showInputDialog("Value of a: "));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Value of b: "));
        int c = Integer.parseInt(JOptionPane.showInputDialog("Value of c: "));

        //int a = Integer.parseInt(aString) , b = Integer.parseInt(bString), c = Integer.parseInt(cString);

        int discriminant = (int)(Math.pow(b, 2) - (4 * a * c));

        if (discriminant < 0) {
            JOptionPane.showMessageDialog(null, "The quadratic has no real roots.",
                    "Result", JOptionPane.WARNING_MESSAGE);
        }
        else if (discriminant == 0) {
            int r1 = (int)(((1 - b) + Math.sqrt(discriminant)) / (2 * a));
                JOptionPane.showMessageDialog(null, "There is 1 real root for this quadratic.\n" +
                        "Root 1 = " + r1, "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            int r1 = (int)(((b * -1) + Math.sqrt(discriminant)) / (2 * a));
            int r2 = (int)(((b * -1) - Math.sqrt(discriminant)) / (2 * a));
            JOptionPane.showMessageDialog(null, "There are 2 real roots for this quadratic. They are:\n" +
                    "Root #1: " + r1 + "\n" +
                    "Root #2: " + r2,
                    "Result", JOptionPane.INFORMATION_MESSAGE);
        }



    }
}
