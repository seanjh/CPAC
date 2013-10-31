public class Midterm2 {
	public static void main(String[] args) {
		int[] a = {6, 8, 6, 35};
		int[] b = {3, 6, 8, 13, 66};

		int[] c = append(a, b);

		System.out.print("a: ");
		printArray(a);
		System.out.print("b: ");
		printArray(b);
		System.out.print("c: ");
		printArray(c);
	}

	public static int[] append(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}

		for (int i = a.length; i < c.length; i++) {
			c[i] = b[i - a.length];
		}

		return c;
	}

	public static void printArray(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
	}
}