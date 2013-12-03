import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = null;

        for (int i = 0; i <= 5; i++) {
            System.out.print("Enter a key >> ");
            input = in.nextLine();
            System.out.println("Input was: " + input + " Empty: " + input.isEmpty());
        }

    }
}
