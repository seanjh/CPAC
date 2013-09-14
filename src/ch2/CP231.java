package ch2;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 9/14/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class CP231 {
    public static void main(String[] args) {
        char x = 'a'; // (int)x = 97
        char y = 'c'; // (int)y = 99

        System.out.println(++x); // b, x = 'b'
        System.out.println(y++); // c, y = 'd'
        System.out.println(x - y); // -2
    }
}
