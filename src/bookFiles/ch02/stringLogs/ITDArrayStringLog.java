/*
* ITDArrayStringLog.java
* 
* Interactive Test Driver for the ArrayStringLog class.
*/

import java.util.*;
import ch02.stringLogs.*;

public class ITDArrayStringLog {
    public static void main(String[] args) {
        ArrayStringLog test = new ArrayStringLog("Testing");
        Scanner in = new Scanner(System.in);

        String skip;        // skip end of line after reading an integer
        boolean keepGoing;  // flag for choose operation loop
        int constructor;    // indicates user's choice of constructor
        int operation;      // indicates user's choice of operation

        System.out.println("What is the name of this test?");
        String testName = in.nextLine();
        System.out.println("\nThis is test " + testName + "\n");

        System.out.println("Chooce a constructor:");
        System.out.println("\t1: ArrayStringLog(String name)");
        System.out.println("\t2: ArrayStringLog(String name, int maxSize)");
        if (in.hasNextInt())
            constructor = in.nextInt();
        else {
            System.out.println("ERROR: You must enter an integer.");
            System.out.println("Terminating test.");
            return;
        }
        skip = in.nextLine();

        switch (constructor) {
            case 1:
            test = new ArrayStringLog(testName);
            break;
            
            case 2:
            System.out.println("Enter a maxSize:");
            int maxSize;
            if (in.hasNextInt())
                maxSize = in.nextInt();
            else {
                System.out.println("ERROR: You must enter an integer.");
                System.out.println("Terminating test.");
                return;
            }
            skip = in.nextLine();
            test = new ArrayStringLog(testName, maxSize);
            break;

            default:
            System.out.println("ERROR in constructor choice. Terminating test.");
            return;
        }

        keepGoing = true;
        while (keepGoing) {
            System.out.println("\nChoose an operation:");
            System.out.println("\t1: insert(String element)");
            System.out.println("\t2: clear()");
            System.out.println("\t3: contains(String element)");
            System.out.println("\t4: isFull()");
            System.out.println("\t5: size()");
            System.out.println("\t6: getName()");
            System.out.println("\t7: show contents");
            System.out.println("\t8: stop testing");
            if (in.hasNextInt())
                operation = in.nextInt();
            else {
                System.out.println("ERROR: You must enter an integer.");
                System.out.println("Terminating test.");
                return;
            }
            skip = in.nextLine();

            switch (operation) {
                case 1: // insert
                System.out.println("Enter a string to insert");
                String insertString = in.nextLine();
                test.insert(insertString);
                break;

                case 2: // clear
                test.clear();
                break;

                case 3: // contains
                System.out.println("Enter a string to search for:");
                String searchString = in.nextLine();
                System.out.println("Result: " + test.contains(searchString));
                break;

                case 4: // isFull
                System.out.println("Result: " + test.isFull());
                break;

                case 5: // size
                System.out.println("Result: " + test.size());
                break;

                case 6: // getName
                System.out.println("Result: " + test.getName());
                break;

                case 7: // show contents
                System.out.println(test);
                break;

                case 8:
                keepGoing = false;
                break;

                default:
                System.out.println("Error in operation choice. Terminating test.");
                return;
            }
        }

        System.out.println("Enf of Interactive Test Driver");
    }
}