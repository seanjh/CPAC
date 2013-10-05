public class TestHM3 {
	public static void main(String[] args) {
		/*for (int i = 0; i < 1000; i++) {
			if ((i+1) % 20 == 0) {
				System.out.println();
			}
			System.out.print((int) (Math.random() * 2));
		}*/

		int[] position = new int[2];

		for (int i = 0; i < 1000; i++) {
			randomPosition(position);
			printPosition(position);

			if ((i+1) % 10 == 0) {
				System.out.println();
			}
		}

		/*int[] testArray = new int[100];

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
		}*/

	}

	public static void randomPosition(int[] position) {
        for (int i = 0; i < position.length; i++) {
            position[i] = (int) (Math.random() * 20 + 1);
        }
    }

    public static void printPosition(int[] position) {
      // Display the current (X,Y) position of the car.
        System.out.print("(" + position[0] + "," + position[1] + ") ");
    }
}