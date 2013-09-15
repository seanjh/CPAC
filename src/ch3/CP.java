package ch3;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/14/13 6:51 PM
 */
public class CP {
    public static void main(String[] args) {
        int answer = JOptionPane.showConfirmDialog(null, "Yes?");
        switch (answer) {
            case 0: JOptionPane.showMessageDialog(null,"Aw yeah!"); break;
            case 1: JOptionPane.showMessageDialog(null,"Oh no!"); break;
            case 2: JOptionPane.showMessageDialog(null,"Quitter."); break;
        }

        // 3.41 1 > 2 && 2 > 5 --> false
        // 1 > 1 || 2 > 5 --> false

        // 19 > 34 && 1 > 5

        /*String dayName = "n/a";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a weekday number (0-6): ");
        int day = input.nextInt();

        switch (day) {
            case 0: dayName = "Sunday"; break;
            case 1: dayName = "Monday"; break;
            case 2: dayName = "Tuesday"; break;
            case 3: dayName = "Wednesday"; break;
            case 4: dayName = "Thursday"; break;
            case 5: dayName = "Friday"; break;
            case 6: dayName = "Saturday"; break;
        }
        if (day <= 6)
            System.out.println("Day " + day + " is " + dayName);
        else
            System.out.println("Day " + day + " is outside a 1 week range.");

        // 3.31
        // 1,3 - 17,3
        int x = 1, a = 3;
        switch (a) {
            case 1: x += 5; break;
            case 2: x += 10; break;
            case 3: x += 16; break;
            case 4: x += 34; break;
        }
        System.out.println(x + ", " + a);

        // 3.30
        int x = 3, y = 3;
        switch (x + 3) {
            case 6: y = 1; // y = 1
            default: y += 1; // y = 2
        }
        System.out.println(x + " " + y);

        int x2 = 3, y2 = 3;
        if ((x2 + 3) == 6)
            y2 = 1;
        y2 += 1;
        System.out.println(x2 + " " + y2);




        // 3.28 weight > 50 ^ height > 60
        // 3.27 weight > 50 && height > 60
        // 3.26 weight > 50 || height > 60
        // 3.25 age < 18 && age > 13
        // 3.24 true, true, false, error
        // 3.22 a) false (x=2) b) false (x=2)

        int x = 350, y = 5;
        System.out.println("x is " + x + " y is " + y);
        x /= y;
        System.out.println("x is " + x + " y is " + y);

        // 3.21
        // no, no, no, no, no, yes

        // 3.20
        // (num > 1 && num < 100) || (num < 0)

        // 3.19
        // num > 1 && num < 100

        // 3.18
        // false, false, true
        // true, true, true

        // if ((income - 372950) > 0) {
        // taxTotal = (income - 372950) * 0.35
        // }

        // 3.16
        // a) 2 * (Math.random() * 10)
        // b) (Math.random() * 10) + 10
        // c) 4 * (Math.random() * 10) + 10

        // 3.15 -- 0.5, 0.0, 0.234

        // 3.12
        int count = 200;
        boolean newLine = (count % 10 == 0);
        System.out.println(newLine);

        // b indented properly
        // a == c == d

        // 3.7
        int x = 4;
        boolean even = x % 2 == 0;
        System.out.println(even);

        // 3.8
        //int x = 3, y = 2;
        int x = 2, y = 2;
        if (x > 2)
            if (y > 2) {
                int z = x + y;
                System.out.println("z is " + z);
            }
            else
                System.out.println("x is " + x);
        else
            System.out.println("x is totally " + x);*/

        // 3.6
        /*double pay = 50000;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a score: ");
        int score = input.nextInt();

        if (score > 90)
            pay = pay + (pay * 0.03);
        else
            pay = pay + (pay * 0.01);

        System.out.println("New pay: " + pay);*/

        /*// 3.4
        int y = 5;
        int x = 0;
        if (y > 0) {
            x = 1;
        }
        System.out.println(x);*/

        // 3.3
        //boolean b = true;
        //int i = (int)b;
        //int i = 1;
        //boolean b = (boolean)i;
        //System.out.println(i);
    }
}
