import java.util.Scanner;

public class TestArrays {
	public static void main(String[] args) {

        int[] x = new int[10];
        for (int i = 0; i < x.length; i++) {
            x[i] = (int) (Math.random() * 6);
        }

        System.out.println("Before Contents of Array 1: ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        int[] y = new int[10];

        y = x;

        y[0] = 10;

        System.out.println("After Contents of Array 1: ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        System.out.println("After Contents of Array 2: ");
        for (int i = 0; i < y.length; i++) {
            System.out.print(y[i] + " ");
        }
        System.out.println();
	}
} 