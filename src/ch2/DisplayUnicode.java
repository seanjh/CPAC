package ch2;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 9/14/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayUnicode {
    public static void main(String[] args) {
        int i = '2' + '3'; // (int)'2' is 60, (int)'3' is 51
        System.out.println("i is " + i);

        int j = 2 + 'a'; // (int)'a' is 97
        System.out.println("j is " + j); // j is 99
        System.out.println(j + "is the Unicode for character "
            + (char)j); // j is the Unicode for character c
        System.out.println("Chapter " + '2');
    }
}
