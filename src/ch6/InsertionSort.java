//package ch6;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		// Initialize the Scanner
		Scanner input = new Scanner(System.in);

		// Create the randomList
		int[] randomList = new int[10000];
        //int[] randomList = {55,32,854,215,687,87893,481,43,35486};

		// Input sorted list of 5000 values
		// list via http://www.random.org/
		System.out.println("Getting input.");
		for (int i = 0; i < randomList.length; i++) {
			randomList[i] = input.nextInt();
		}

		displayList(randomList, 18);

		System.out.println("Beginning insertion sort.");
        int operations = 0;
        operations = insertionSort(randomList, operations);

		System.out.println("Done insertion sort.");
		displayList(randomList, 18);

        System.out.println();
        System.out.printf("Completed %,d total operations (%,.2f ops / item)", operations, ((float)operations / randomList.length));

	}

	public static int insertionSort(int[] list, int operations) {
		int minimum = list[0];
        int maximum = list[0];
		// Insert each value in the sorted sublist
		for (int i = 1; i < list.length; i++) {
            operations += 1; // 1 check
            if (list[i] < minimum) {
                minimum = list[i]; // new minimum
                shiftRight(0, i, list[i], list);
                operations += i; // number of shifts
            } else if (list[i] > maximum) {
                maximum = list[i];
                // no shifts
            } else {
                int insertIndex = findPlace(i, list[i], list);
                operations += (i-insertIndex); // number of lookups
                shiftRight(insertIndex, i, list[i], list);
                operations += (i-insertIndex); // number of shifts
            }
        }

        return operations;
    }

    public static int findPlace(int indexEnd, int targetValue, int[] list) {
        int i;
        for (i = 1; i < indexEnd; i++) {
            if (targetValue <= list[i]) {
                return i;
            }
        }
        return i;
    }

    public static void shiftRight(int start, int finish, int insertValue, int[] list) {
        for (int i = finish; i > start; i--) {
            list[i] = list[i-1];
        }
        list[start] = insertValue;
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