import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		// Initialize the Scanner
		Scanner input = new Scanner(System.in);

		// Creat the randomList
		int[] randomList = new int[10000];

		// Input sorted list of 5000 values
		// list via http://www.random.org/
		System.out.println("Getting input.");
		for (int i = 0; i < randomList.length; i++) {
			//randomList[i] = input.nextInt();
            randomList[i] =(int) (Math.random() * 1000000) + 1;
		}

		// displayList(randomList, 12);

		System.out.println("Beginning selection sort.");
        int operations = 0;
        operations = selectionSort(randomList, operations);

		System.out.println("Done selection sort.");
		displayList(randomList, 12);

        System.out.println();
        System.out.printf("Completed %,d total operations (%,.2f ops / item)", operations, ((float)operations / randomList.length));
	}

	public static int selectionSort(int[] list, int operations) {
		for (int i = 0; i < list.length; i++) {
            operations += 1;
			operations += swapInMimumum(i, list);
		}

        return operations;
	}

	public static int swapInMimumum(int startIndex, int[] list) {
		int minIndex = startIndex;
		int minValue = list[startIndex];
        int operations = 0;

		// Find the index for the minimum value in the remaining array
		for (int i = (startIndex + 1); i < list.length; i++) {
            operations += 1; // one check
			if (list[i] < minValue) {
				minIndex = i;
				minValue = list[i];
			}
		}

		// Swap the values at startIndex and minIndex
		int temp = list[startIndex]; // preserve the original value
		list[startIndex] = minValue; // replace with new minimum value
		list[minIndex] = temp; // move the original to the minimum's position
        operations += 3; // swapped values

        return operations;
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