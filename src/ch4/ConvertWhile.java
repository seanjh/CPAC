import java.util.Scanner;

public class ConvertWhile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sum = 0, number = sum;
		
		do {
			sum += number;
			System.out.print("Enter an integer " +
				"(the input ends if it is 0): ");
			number = input.nextInt();
		} while (number != 0);
		
		System.out.println("The sum is " + sum);
	}
}			
