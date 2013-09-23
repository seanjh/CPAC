/**
 * Created with IntelliJ IDEA.
 * CPAC
 * User: Sean
 * Date: 9/18/13 8:32 PM
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        int result = 2;
        int exponent = 1;
        while (result < 1000) {
            result =(int)Math.pow(result, exponent);
            exponent++;
        }

        System.out.print(result);
    }
}
