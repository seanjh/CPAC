public class TestHM3 {
	public static void main(String[] args) {
		int[] testArray = new int[100];

		for (int i =0; i < testArray.length; i++) {
			testArray[i] = (int) (Math.random() * 20 + 1);
		}

		System.out.println("Contents of the array:");
		for (int i = 0; i < testArray.length; i++) {
			if ((i+1) % 15 == 0) 
				System.out.printf("%d\n", testArray[i]);
			System.out.printf("%-3d", testArray[i]);
		}


		int[] testArrayFive = new int[1000];

		for (int i =0; i < testArrayFive.length; i++) {
			testArrayFive[i] = (int) (Math.random() * 5);
		}


		System.out.println();
		System.out.println();
		System.out.println("Contents of the arrayFive:");
		for (int i = 0; i < testArrayFive.length; i++) {
			if ((i+1) % 15 == 0) 
				System.out.printf("%d\n", testArrayFive[i]);
			System.out.printf("%-2d", testArrayFive[i]);
		}

	}
}