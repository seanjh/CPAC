import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		// Initialize the Scanner
		Scanner input = new Scanner(System.in);

		// Creat the randomList
		int[] randomList = new int[5000];

		// Input sorted list of 5000 values
		// list via http://www.random.org/
		System.out.println("Getting input.");
		for (int i = 0; i < randomList.length; i++) {
			randomList[i] = input.nextInt();
		}

		// displayList(randomList, 12);

		System.out.println("Beginning selection sort.");
		selectionSort(randomList);

		System.out.println("Done selection sort.");
		displayList(randomList, 12);
	}

	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length; i++) {
			swapInMimumum(i, list);
		}
	}

	public static void swapInMimumum(int startIndex, int[] list) {
		int minIndex = startIndex;
		int minValue = list[startIndex];

		// Find the index for the minimum value in the remaining array
		for (int i = (startIndex + 1); i < list.length; i++) {
			if (list[i] < minValue) {
				minIndex = i;
				minValue = list[i];
			}
		}

		// Swap the values at startIndex and minIndex
		int temp = list[startIndex]; // preserve the original value
		list[startIndex] = minValue; // replace with new minimum value
		list[minIndex] = temp; // move the original to the minimum's position
	}

	public static void displayList(int[] list, int columns) {
		for (int i = 0; i < list.length; i++) {
			// Display the value
			System.out.printf("%-7d", list[i]);
			
			// Print a newline for every COLUMNS values
			if ((i + 1) % columns == 0) {
				System.out.println();
			}
		}
		System.out.println();
	} 

}