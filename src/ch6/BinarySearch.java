import java.util.Scanner;
import javax.swing.JOptionPane;

public class BinarySearch {
	public static void main(String[] args) {
		// Initialize the Scanner
		Scanner input = new Scanner(System.in);

		// Creat the sortedList
		int[] sortedList = new int[100];

		// Input sorted list of 1000 values
		// list via http://www.augustana.ca/~mohrj/algorithms/randpick.html
		for (int i = 0; i < sortedList.length; i++) {
			sortedList[i] = (int)(Math.random() * 10001);
		}

		// Get the key value
		//System.out.println(": ");
		//String inputValue = JOptionPane.showInputDialog("Enter a number to" + 
		//	" lookup (from 0 to 10,000)");
		System.out.println("Enter a number to lookup (from 0 to 10,000)");
		int keyValue = input.nextInt();
		//int keyValue = Integer.parseInt(inputValue);

		// Display the list
		displayList(sortedList, 15);

		int keyIndex = binarySearch(keyValue, sortedList);

		displayResult(keyIndex, keyValue, sortedList.length);
	}

	public static void displayList(int[] list, int columns) {
		for (int i = 0; i < list.length; i++) {
			// Display the value
			System.out.printf("%-6d", list[i]); //10000
			
			// Print a newline for every columns values
			if ((i + 1) % columns == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
	} // end of displayList()


	public static int binarySearch(int key, int[] list) {
		int high = list.length - 1;
		int low = 0;
		int mid;

		do {
			mid = getMidpoint(low, high);
			displayStatus(key, low, mid, high, list);
			if (key < list[mid]) {
				high = mid - 1;
			} else if (key > list[mid]) {
				low = mid + 1;
			}
		} while (list[mid] != key && high >= low);

		// If our middle index equals the key, we found a match
		if (list[mid] == key)
			return mid;
		else
			return -1;
	}

	public static int getMidpoint(int low, int high) {
		return ((low + high) / 2);
	}

	public static void displayStatus(int key, int low, int mid, int high, 
		int[] list) {
		System.out.println("Checking list for " + key + " at midpoint " + mid + 
			" (" + list[mid] + ") from list between index " + low + " (" + 
			list[low] + ") and " + high + " (" + list[high] + ")");
	}

	public static void displayResult(int index, int value, int length) {
		if (index == -1) {
			System.out.println(value + " was not located in the list.");
		} else {
			System.out.println(value + " was located at index " + index + 
				" of " + (length -1));
		}
	}

}
