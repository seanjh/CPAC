import java.util.Scanner;

public class TestArrays {
	public static void main(String[] args) {
		
		/*// Create new array of doubles
		double[] myList = new double[4];

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter " + myList.length + " values." );

		// Input each element
		for (int i = 0; i < myList.length; i++) {
			System.out.print("Value #" + (i + 1) + ": ");
			myList[i] = input.nextDouble();
		}

		// For-each loop
		for (double e: myList) {
			System.out.println(e);
		}

		double[] myNewList = {3.5, 5.5, 4.52, 5.6};

		for (double e: myNewList) {
			System.out.print(e + " ");
		}

		System.out.println();

		double[] r = new double[100];*/

		// 6.12
		int[] source = {3, 4, 5};
		System.out.println("source array contents");
		for (int e: source) {
			System.out.println(e);
		}

		int[] target = new int[3];
		//int[] target; // no worky (declared, not created/initialized)
		System.arraycopy(source, 0, target, 0, source.length);

		System.out.println("target array contents");
		for (int e: target) {
			System.out.println(e);
		}

	}
} 