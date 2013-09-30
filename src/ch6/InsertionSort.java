import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		// Initialize the Scanner
		Scanner input = new Scanner(System.in);

		// Creat the randomList
		int[] randomList = new int[100];

		// Input sorted list of 5000 values
		// list via http://www.random.org/
		System.out.println("Getting input.");
		for (int i = 0; i < randomList.length; i++) {
			randomList[i] = input.nextInt();
		}

		// displayList(randomList, 12);

		System.out.println("Beginning insertion sort.");
		insertionSort(randomList);

		System.out.println("Done insertion sort.");
		displayList(randomList, 12);
	}

	public static void insertionSort(int[] list) {
		// Insert each value in the sorted sublist
		for (int i = 1; i < list.length; i++) {
			insertValue(0, i, list);
		}
	}

	public static void insertValue(int indexStart, int indexEnd, int[] list) {
		int currentValue;
		for (int i = (indexEnd); i > indexStart; i--) {
			currentValue = list[indexEnd];
			if (currentValue > list[i-1] && currentValue <= list[i]) {
				shiftListRight(i, indexEnd, currentValue, list);
			}
		}
	}

	public static void shiftListRight(int indexStart, int indexEnd, int current, int[] list) {
		for (int i = indexEnd; i > indexStart; i--) {
			list[i] = list[i-1];
		}
		list[indexStart] = current;
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



/*
5,7,8,9,2 - start
5,7,8,8,9 - 2=9, 9=8
5,7,7,8,9
5,5,7,8,9
2,5,7,8,9

5,7,8,9,2 - start
5,7,8,9,9
5,7,8,8,9
5,7,7,8,9
5,5,7,8,9
2,5,7,8,9

5,7,8,9,2

5,7,8,9,9 - 4,3
5,7,8,8,9 - 3,2
5,7,7,8,9 - 2,1
5,5,7,8,9 - 1,0
after 2,5,7,8,9 

*/